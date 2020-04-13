/**
 * @Title: CategoryServiceImpl.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;

/**
 * @Name: CategoryServiceImpl
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * @Title: listCategory
     * @Description: TODO(描述)
     * @param page
     * @return
     * @see com.how2java.tmall.service.CategoryService#listCategory(com.how2java.tmall.util.Page)
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    @Override
    public List<Category> listCategory(Page page) {
        return categoryMapper.listCategory(page);
    }

    /**
     * @Title: total
     * @Description: TODO(描述)
     * @return
     * @see com.how2java.tmall.service.CategoryService#total()
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    @Override
    public int total() {
        return categoryMapper.total();
    }

    /**
     * @Title: insertCategory
     * @Description: TODO(增加category)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     * @see com.how2java.tmall.service.CategoryService#insertCategory(com.how2java.tmall.pojo.Category)
     */
    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertCategory(category);
    }

    /**
     * @Title: deleteCategory
     * @Description: TODO(删除category)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @see com.how2java.tmall.service.CategoryService#deleteCategory(int)
     */
    @Override
    public void deleteCategory(int id) {
        categoryMapper.deleteCategoryById(id);
    }

    /**
     * @Title: getCategoryById
     * @Description: TODO(通过id获取category名称，用于编辑功能)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @return
     * @see com.how2java.tmall.service.CategoryService#getCategoryById(int)
     */
    @Override
    public Category getCategoryById(int id) {
        return categoryMapper.getCategoryById(id);
    }

    /**
     * @Title: updateCategory
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     * @see com.how2java.tmall.service.CategoryService#updateCategory(com.how2java.tmall.pojo.Category)
     */
    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);

    }

}
