/**
 * @Title: CategoryController.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.controller;

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

/**
 * 
 * @Name: CategoryController
 * @Description: TODO(描述)
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
    public String listAllCategory(Category category, Model model, HttpSession session, Page page) {
        logger.info("CategoryController : 调用listAllCategory方法");
        // 返回categoryList集合
        List<Category> categoryList = categoryService.listCategory(page);
        // 定义total 返回分页的时候整个数量的方法
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }
}
