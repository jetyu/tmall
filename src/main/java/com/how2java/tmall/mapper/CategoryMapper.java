package com.how2java.tmall.mapper;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

/**
 * 
 * @Name: CategoryMapper
 * @Description: TODO(Category接口方法)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public interface CategoryMapper {

    /**
     * 列出整个目录
     *
     * @Title: listCategory
     * @Author Jet Yu
     * @Date 2020-04-13
     * @param page
     * @return
     */
    List<Category> listCategory(Page page);

    /**
     * total方法
     * 
     * @Title: total
     * @return
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    int total();
}