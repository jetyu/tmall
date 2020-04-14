/**
 * @Title: CategoryService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

/**
 * @Name: CategoryService
 * @Description: TODO(Category的增删改查功能)
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
    List<Category> list();

    /**
     * 取category整个list
     *
     * @Title: listCategory
     * @Author Jet Yu
     * @Date 2020-04-13
     * @param page
     * @return List<Category>
     */
    List<Category> listCategory(Page page);

    /**
     * total
     *
     * @Title: total
     * @Author Jet Yu
     * @Date 2020-04-13
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
