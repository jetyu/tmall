/**
 * @Title: PropertyService.java
 * @Description: PropertyService(描述)
 * @Author Jet Yu
 * @Date 2020-04-15
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Property;

/**
 * @Name: PropertyService
 * @Description: PropertyService(描述)
 * @Author Jet Yu
 * @Date 2020-04-15
 */
public interface PropertyService {
    /**
     * 通过id获取1个category名称，用于编辑category名称
     *
     * @Title: getPropertyById
     * @Author Jet Yu
     * @Date 2020-04-14
     * @param id
     * @return getPropertyById
     */
    Property getPropertyById(int id);

    /**
     * 列出所有属性值 需要注意的是，因为在业务上需要查询某个分类下的属性，所以list方法会带上对应分类的id。
     * 
     * @Title: listProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @return
     */
    List<Property> listProperty(int cid);

    /**
     * 插入属性值
     *
     * @Title: insertProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     */
    void insertProperty(Property property);

    /**
     * 更新属性值
     *
     * @Title: updateProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param property
     */
    void updateProperty(Property property);

    /**
     * 删除属性值
     *
     * @Title: deleteProperty
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param property
     */
    void deleteProperty(int id);
}
