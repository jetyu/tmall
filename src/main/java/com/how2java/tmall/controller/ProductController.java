/**
 * @Title: ProductController.java
 * @Description: TODO(描述)
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
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;

/**
 * @Name: ProductController
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
@Controller
@RequestMapping("")
public class ProductController {
    /**
     * 定义logger
     */
    private Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categorService;

    @RequestMapping("admin_product_list")
    public String listProduct(int cid, Model model, Page page) {
        logger.info("调用product LIST方法");
        Category c = categorService.getCategoryById(cid);
        List<Product> ps = productService.listProduct(cid);
        // 调入pagehelper插件
        PageHelper.offsetPage(page.getStart(), 10);
        // 定义total 返回分页的时候整个数量的方法
        int total = (int)new PageInfo<>().getTotal();
        page.setTotal(total);
        model.addAttribute("c", c);
        model.addAttribute("ps", ps);
        return "admin/listProduct";
    }

    @RequestMapping("admin_product_add")
    public String insertProduct(Product p) {
        productService.insertProduct(p);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_delete")
    public String deleteProduct(int id) {
        Product p = productService.getProductById(id);
        productService.deleteProduct(id);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }

    @RequestMapping("admin_product_edit")
    public String editProduct(int id, Model model) {
        Product p = productService.getProductById(id);
        Category c = categorService.getCategoryById(p.getCid());
        model.addAttribute("p", p);
        model.addAttribute("c", c);
        return "admin/editProduct";
    }

    @RequestMapping("admin_product_update")
    public String updateProduct(Product p) {
        productService.updateProduct(p);
        return "redirect:admin_product_list?cid=" + p.getCid();
    }
}
