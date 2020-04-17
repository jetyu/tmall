/**
 * @Title: PropertyController.java
 * @Description: PropertyController(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
package com.how2java.tmall.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.util.Page;

/**
 * @Name: PropertyController
 * @Description: PropertyController(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
@Controller
@RequestMapping("")
public class PropertyController {

    /**
     * 定义logger
     */
    private Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    PropertyService propertyService;
    @Autowired
    CategoryService categoryService;

    /**
     * 罗列属性
     *
     * @Title: listProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param cid
     * @param page
     * @param model
     * @return
     */
    @RequestMapping("admin_property_list")
    public String listProperty(int cid, Page page, Model model) {

        logger.info("删除");
        // 通过category的ID来获取值
        Category c = categoryService.getCategoryById(cid);
        List<Property> ps = propertyService.listProperty(cid);
        // 调入pagehelper插件
        PageHelper.offsetPage(page.getStart(), 10);
        // 定义total 返回分页的时候整个数量的方法
        int total = (int)new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        model.addAttribute("c", c);
        model.addAttribute("ps", ps);
        model.addAttribute("page", page);
        return "admin/listProperty";
    }

    /**
     * 增加属性
     *
     * @Title: insertProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param p
     * @param model
     * @return
     */
    @RequestMapping("admin_property_add")
    public String insertProperty(Property p, Model model) {
        propertyService.insertProperty(p);
        model.addAttribute("p", p);
        return "redirect:admin_product_list?cid="+p.getCid();
    }

    /**
     * 删除属性
     *
     * @Title: deleteProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param id
     * @return
     */
    @RequestMapping("admin_property_delete")
    public String deleteProperty(int id) {
        Property p = propertyService.getPropertyById(id);
        propertyService.deleteProperty(id);
        return "redirect:admin_property_list?cid=" + p.getCid();
    }

    /**
     * 
     *
     * @Title: editProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("admin_property_edit")
    public String editProperty(Model model, int id) {
        Property p = propertyService.getPropertyById(id);
        model.addAttribute("p", p);
        return "admin/editProperty";
    }

    /**
     * 
     *
     * @Title: updateProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param p
     * @return
     */
    @RequestMapping("admin_property_update")
    public String updateProperty(Property p) {
        propertyService.updateProperty(p);
        return "redirect:admin_property_list?cid=" + p.getCid();
    }

}
