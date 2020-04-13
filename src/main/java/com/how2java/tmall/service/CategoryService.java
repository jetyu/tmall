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
     * @Author Jet Yu
     * @Date 2020-04-13
     * @param page
     * @return
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
}
