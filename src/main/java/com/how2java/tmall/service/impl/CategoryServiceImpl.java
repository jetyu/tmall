package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {

    /**
     * @Title: total
     * @Description: 重写
     * @see com.how2java.tmall.service.CategoryService#total()
     */
    @Override
    public int total() {

        return 0;
    }

    /**
     * @Title: list
     * @Description: 重写
     * @see com.how2java.tmall.service.CategoryService#list(com.how2java.tmall.util.Page)
     */
    @Override
    public List<Category> list(Page page) {

        return null;
    }
   
    /**
     * @Title: add
     * @Description: 重写
     * @see com.how2java.tmall.service.CategoryService#add(com.how2java.tmall.pojo.Category)
     */
    @Override
    public void add(Category category) {}

}