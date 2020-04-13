/**
 * @Title: CategoryController.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;

/**
 * @Name: CategoryController
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
@Controller
@RequestMapping("")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_category_list")
    public String listAllCategory(Category category, Model model, HttpSession session, Page page) {
        List<Category> categoryList = categoryService.listCategory(page);
        int total = categoryService.total();
        page.setTotal(total);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("page", page);
        return "admin/listCategory";
    }

}
