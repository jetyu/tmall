package com.how2java.tmall.mapper;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

/**
 * @Name: CategoryMapper
 * @Description: TODO(Category接口 CRUD方法)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public interface CategoryMapper {

    /**
     * 获取所有category
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
     * @Author Jet Yu
     * @Date 2020-04-14
     * @return
     */
    int total();

    /**
     * 增加category名称
     *
     * @Title: insertCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     */
    void insertCategory(Category category);

    /**
     * 删除category名称
     *
     * @Title: deleteCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     */
    void deleteCategoryById(int id);

    /**
     * 通过id获取1个category名称，用于编辑category名称
     *
     * @Title: getCategoryById
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @return
     */
    Category getCategoryById(int id);

    /**
     * 更新category名称
     *
     * @Title: updateCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     */
    void updateCategory(Category category);
}