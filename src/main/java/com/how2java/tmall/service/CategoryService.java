/**
 * @Title: CategoryService.java
 * @Description: CategoryService
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;

/**
 * @Name: CategoryService
 * @Description: Category的增删改查功能
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public interface CategoryService {

    /**
     * 获取所有category,采取pageHelper的方式
     *
     * @Title: listAllCategory
     * @Author Jet Yu
     * @Date 2020-04-14
     * @return
     */
    List<Category> listCategory();

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
     * @throws CustomException
     * @throws Exception
     */
    void deleteCategory(int id);

    /**
     * 通过id获取1个category名称，用于编辑category名称
     *
     * @Title: getCategoryById
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @return Category
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
