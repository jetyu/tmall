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
     * 取category整个list
     *
     * @Title: listCategory
     * @param page
     * @return
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    List<Category> listCategory(Page page);

    /**
     * 计算分页的时候整个数量的方法
     *
     * @Title: total
     * @return
     * @Author Jet Yu
     * @Date 2020-04-13
     */
    int total();
}
