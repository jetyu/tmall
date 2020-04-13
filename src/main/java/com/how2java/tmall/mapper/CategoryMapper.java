package com.how2java.tmall.mapper;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

/**
 * @Name: CategoryMapper
 * @Description: Category的接口方法
 * @Author Jet Yu
 * @Date: Apr 13, 2020 7:40:43 PM
 */
public interface CategoryMapper {
    /**
     * 列出整个category
     *
     * @Title: listCategory
     * @param page
     * @return
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    List<Category> listCategory(Page page);

    /**
     * 
     *
     * @Title: total
     * @return
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    int total();
}