/**
 * @Title: PropertyValueService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.PropertyValue;

/**
 * @Name: PropertyValueService
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
public interface PropertyValueService {
    List<PropertyValue> listPropertyValue(int pid);

    void init(Product p);

    void updatePropertyValue(PropertyValue pv);

    PropertyValue getPropertyValueById(int ptid, int pid);

}
