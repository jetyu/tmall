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

}
