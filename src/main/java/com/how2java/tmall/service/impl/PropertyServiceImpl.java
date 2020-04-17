/**
 * @Title: PropertyServiceImpl.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.PropertyMapper;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyExample;
import com.how2java.tmall.service.PropertyService;

/**
 * @Name: PropertyServiceImpl
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyMapper propertyMapper;

    /**
     * @Title: listProperty
     * @Description: listProperty(描述) 对属性值进行遍历查询
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param cid
     * @return
     * @see com.how2java.tmall.service.PropertyService#listProperty(int)
     */
    @Override
    public List<Property> listProperty(int cid) {
        PropertyExample example = new PropertyExample();
        // CreateCriteria这个相当于查询
        example.createCriteria().andCidEqualTo(cid);
        // 查询结果先按id字段排序
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);

    }

    /**
     * @Title: insertProperty
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param property
     * @see com.how2java.tmall.service.PropertyService#insertProperty(com.how2java.tmall.pojo.Property)
     */
    @Override
    public void insertProperty(Property property) {
        propertyMapper.insertSelective(property);
    }

    /**
     * @Title: updateProperty
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param property
     * @see com.how2java.tmall.service.PropertyService#updateProperty(com.how2java.tmall.pojo.Property)
     */
    @Override
    public void updateProperty(Property property) {
        propertyMapper.updateByPrimaryKeySelective(property);
    }

    /**
     * @Title: deleteProperty
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param property
     * @see com.how2java.tmall.service.PropertyService#deleteProperty(com.how2java.tmall.pojo.Property)
     */
    @Override
    public void deleteProperty(int id) {
        propertyMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Title: getPropertyById
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param id
     * @return
     * @see com.how2java.tmall.service.PropertyService#getPropertyById(int)
     */
    @Override
    public Property getPropertyById(int id) {
        return propertyMapper.selectByPrimaryKey(id);
    }

}
