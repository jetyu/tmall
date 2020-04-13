/**
 * @Title: CategoryController.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;
import com.how2java.tmall.util.UploadedImageFile;

/**
 * 
 * @Name: CategoryController
 * @Description: TODO(分类页面的控制器)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
@Controller
@RequestMapping("")
public class CategoryController {

    /**
     * 自动装配
     */
    @Autowired
    CategoryService categoryService;

    /**
     * 定义logger
     */
    private Logger logger = LoggerFactory.getLogger(CategoryController.class);

    /**
     * @Title: listAllCategory
     * @Author Jet Yu
     * @Date 2020-04-13
     * @param category
     * @param model
     * @param session
     * @param page
     * @return
     */
    @RequestMapping("admin_category_list")
    public String listAllCategory(Category category, Model model, HttpSession session, Page page, UploadedImageFile uploadedImageFile) {
        logger.info("CategoryController : 调用listAllCategory方法");
        // 返回categoryList集合
        List<Category> categoryList = categoryService.listCategory(page);
        // 定义total 返回分页的时候整个数量的方法
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("page", page);
        // 获取图片文件夹路径，通过session获取ServletContext,再通过getRealPath定位存放分类图片的路径。
        File imageFoldPath = new File(session.getServletContext().getRealPath("img/category"));
        // 删除macOS系统上DS_Store文件 防止统计出错
        File dsStoreFile = new File(imageFoldPath, ".DS_Store");
        dsStoreFile.delete();
        // 把文件夹路径转换为字符串类型
        String imageFoldPathToString = imageFoldPath.toString();
        // 获取分类图片路径下，图片文件的数量
        uploadedImageFile.getFileCount(imageFoldPathToString);
        // 获取分类图片，遍历图片文件路径信息
        uploadedImageFile.getFileList(imageFoldPathToString);
        // 客户端跳转到admin_category_list
        return "admin/listCategory";
    }

    /**
     * 增加分类
     *
     * @Title: insertOneCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param model
     * @param category接受页面提交的分类名称
     * @param session用于在后续获取当前应用的路径
     * @param uploadedImageFile上传图片工具类
     * @return
     */
    @RequestMapping("admin_category_add")
    public String insertOneCategory(Model model, Category category, HttpSession session, UploadedImageFile uploadedImageFile) {
        logger.info("CategoryController : 调用insertOneCategory方法");
        // 通过categoryService保存category对象 ,调用insert方法插入名称，id是自增的，所以不用管，都在category这个POJO里面
        categoryService.insertCategory(category);
        // 获取图片文件夹路径，通过session获取ServletContext,再通过getRealPath定位存放分类图片的路径。
        File imageFoldPath = new File(session.getServletContext().getRealPath("img/category"));
        // 把文件夹路径转换为字符串类型
        String imageFoldPathToString = imageFoldPath.toString();
        // 根据id创建文件名
        File imageFile = new File(imageFoldPath, category.getId() + ".jpg");
        // 如果/img/category目录不存在，则创建该目录
        if (!imageFoldPath.exists()) {
            imageFoldPath.mkdirs();
        }
        try {
            // 通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
            uploadedImageFile.getImage().transferTo(imageFile);
            logger.info(imageFoldPathToString);
        } catch (Exception e) {
            logger.error("Upload Image File has occurred error!", e);
        }
        model.addAttribute("category", category);
        // redirect到admin_category_list
        return "redirect:/admin_category_list";
    }

    /**
     * 删除分类
     *
     * @Title: deleteOneCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @param model
     * @param session
     * @param uploadedImageFile
     * @return
     */
    @RequestMapping("admin_category_delete")
    public String deleteOneCategory(int id, Model model, HttpSession session, UploadedImageFile uploadedImageFile) {
        logger.info("CategoryController : 调用deleteOneCategory方法");
        categoryService.deleteCategory(id);
        // 获取图片文件夹路径，通过session获取ServletContext,再通过getRealPath定位存放分类图片的路径。
        File imageFoldPath = new File(session.getServletContext().getRealPath("img/category"));
        // 获取图片文件名
        File imageFile = new File(imageFoldPath, id + ".jpg");
        logger.info("准备要删除的图片为：" + imageFile.toString());
        try {
            if (!imageFile.exists()) {
                // 删除图片文件
                imageFile.delete();
            }
        } catch (Exception e) {
            logger.error("Delete image file has occurred error!", e);
        }
        // 把文件夹路径转换为字符串类型
        String imageFoldPathToString = imageFoldPath.toString();
        // 获取分类图片路径下，图片文件的数量
        uploadedImageFile.getFileCount(imageFoldPathToString);
        // redirect到admin_category_list
        return "redirect:/admin_category_list";
    }

    /**
     * 编辑category
     *
     * @Title: editCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @param model
     * @param category
     * @return
     */
    @RequestMapping("admin_category_edit")
    public String editCategory(int id, Model model) {
        logger.info("CategoryController : 调用editCategory方法");
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        // redirect到admin_category_list
        return "admin/editCategory";
    }

    /**
     * 
     *
     * @Title: updateCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     *            参数 Category c接受页面提交的分类名称
     * @param model
     * @param session
     *            参数 session 用于在后续获取当前应用的路径
     * @param uploadedImageFile
     *            UploadedImageFile 用于接受上传的图片
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("admin_category_update")
    public String updateCategory(Category category, Model model, HttpSession session, UploadedImageFile uploadedImageFile)
        throws IllegalStateException, IOException {
        logger.info("CategoryController : 调用updateCategory方法");
        // 通过categoryService更新c对象
        categoryService.updateCategory(category);
        // 获取图片文件夹路径，通过session获取ServletContext,再通过getRealPath定位存放分类图片的路径。
        File imageFoldPath = new File(session.getServletContext().getRealPath("img/category"));
        // 根据id创建文件名
        File imageFile = new File(imageFoldPath, category.getId() + ".jpg");
        logger.info("准备要更新的图片为：" + imageFile.toString());

        try {
            uploadedImageFile.getImage().transferTo(imageFile);

        } catch (Exception e) {
            logger.error("Update image file has occurred error!", e);
        }

        model.addAttribute("category", category);
        // 客户端跳转到admin_category_list
        return "redirect:/admin_category_list";
    }
}
