/**
 * @Title: PropertyValueController.java
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.PropertyValueService;

/**
 * @Name: PropertyValueController
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Controller
@RequestMapping("")
public class PropertyValueController {
    @Autowired
    PropertyValueService propertyValueService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping("admin_propertyValue_edit")
    public String edit(Model model, int pid) {
        Product p = productService.getProductById(pid);
        Category c = categoryService.getCategoryById(p.getCid());
        propertyValueService.init(p);
        List<PropertyValue> pvs = propertyValueService.listPropertyValue(p.getId());
        model.addAttribute("p", p);
        model.addAttribute("pvs", pvs);
        model.addAttribute("c", c);
        return "admin/editPropertyValue";
    }

    @RequestMapping("admin_propertyValue_update")
    @ResponseBody
    public String update(PropertyValue pv) {
        propertyValueService.updatePropertyValue(pv);
        return "success";
    }
}
