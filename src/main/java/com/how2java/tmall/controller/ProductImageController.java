/**
 * @Title: ProductImageController.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.util.UploadedImageFile;

/**
 * @Name: ProductImageController
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Controller
@RequestMapping("")
public class ProductImageController {
    @Autowired
    ProductImageService productImageService;

    @RequestMapping("admin_productImage_add")
    public String insertProductImage(Model model, HttpSession session, UploadedImageFile uploadedImageFile) {
//        // 获取图片文件夹路径，通过session获取ServletContext,再通过getRealPath定位存放分类图片的路径。
//        File imageFoldPath = new File(session.getServletContext().getRealPath("img/category"));
//        // 把文件夹路径转换为字符串类型
//        String imageFoldPathToString = imageFoldPath.toString();
//        // 根据id创建文件名
//        File imageFile = new File(imageFoldPath, category.getId() + ".jpg");
//        // 如果/img/category目录不存在，则创建该目录
//        if (!imageFoldPath.exists()) {
//            imageFoldPath.mkdirs();
//        }
//        try {
//            // 通过UploadedImageFile 把浏览器传递过来的图片保存在上述指定的位置
//            uploadedImageFile.getImage().transferTo(imageFile);
//            logger.info(imageFoldPathToString);
//        } catch (Exception e) {
//            logger.error("Upload Image File has occurred error!", e);
//        }
//        model.addAttribute("category", category);
//        // redirect到admin_category_list
         return "redirect:/admin_productImage_list";
    }
}
