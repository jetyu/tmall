/**
 * @Title: CategoryServiceImpl.java
 * @Description: CategoryServiceImpl(描述)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.CategoryExample;
import com.how2java.tmall.service.CategoryService;

/**
 * @Name: CategoryServiceImpl
 * @Description: 分类的实现
 * @Author Jet Yu
 * @Date 2020-04-13
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 
     * @Title: listCategory
     * @Description: 遍历整个分类
     * @Author Jet Yu
     * @Date 2020-04-14
     * @return
     * @see com.how2java.tmall.service.CategoryService#listCategory()
     */
    @Override
    public List<Category> listCategory() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }

    /**
     * @Title: insertCategory
     * @Description: 增加category)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     * @see com.how2java.tmall.service.CategoryService#insertCategory(com.how2java.tmall.pojo.Category)
     */
    @Override
    public void insertCategory(Category category) {
        categoryMapper.insertSelective(category);
    }

    /**
     * @Title: deleteCategory
     * @Description: 删除category)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @see com.how2java.tmall.service.CategoryService#deleteCategory(int)
     */
    @Override
    public void deleteCategory(int id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Title: getCategoryById
     * @Description: 通过id获取category名称，用于编辑功能)
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @return
     * @see com.how2java.tmall.service.CategoryService#getCategoryById(int)
     */
    @Override
    public Category getCategoryById(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    /**
     * @Title: updateCategory
     * @Description: 更新分类
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param category
     * @see com.how2java.tmall.service.CategoryService#updateCategory(com.how2java.tmall.pojo.Category)
     */
    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateByPrimaryKeySelective(category);

    }

}
