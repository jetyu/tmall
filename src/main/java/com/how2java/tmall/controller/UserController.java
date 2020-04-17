/**
 * @Title: UserController.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;
import com.how2java.tmall.util.Page;

/**
 * @Name: UserController
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Controller
@RequestMapping("")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("admin_user_list")
    public String listUser(Model model, Page page) {

        List<User> us = userService.listUser();
        int total = (int)new PageInfo<>(us).getTotal();
        page.setTotal(total);
        model.addAttribute("us", us);
        model.addAttribute("page", page);

        return "admin/listUser";
    }
}
