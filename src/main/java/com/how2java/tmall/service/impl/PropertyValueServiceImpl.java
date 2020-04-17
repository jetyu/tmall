/**
 * @Title: PropertyValueServiceImpl.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.PropertyValueMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.pojo.PropertyValueExample;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;

/**
 * @Name: PropertyValueServiceImpl
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    PropertyValueMapper propertyValueMapper;
    @Autowired
    PropertyService propertyService;

    /**
     * @Title: listPropertyValue
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param pid
     * @return
     * @see com.how2java.tmall.service.PropertyValueService#listPropertyValue(int)
     */
    @Override
    public List<PropertyValue> listPropertyValue(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv : result) {
            Property property = propertyService.getPropertyById(pv.getPtid());
            pv.setProperty(property);
        }
        return result;
    }

    /**
     * @Title: getPropertyValueById
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param ptid
     * @param pid
     * @return
     * @see com.how2java.tmall.service.PropertyValueService#getPropertyValueById(int, int)
     */
    @Override
    public PropertyValue getPropertyValueById(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs = propertyValueMapper.selectByExample(example);
        if (pvs.isEmpty()) {
            return null;
        }
        return pvs.get(0);
    }

    /**
     * @Title: updatePropertyValue
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param pv
     * @see com.how2java.tmall.service.PropertyValueService#updatePropertyValue(com.how2java.tmall.pojo.PropertyValue)
     */
    @Override
    public void updatePropertyValue(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }

    /**
     * @Title: init
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param p
     * @see com.how2java.tmall.service.PropertyValueService#init(com.how2java.tmall.pojo.Product)
     */
    @Override
    public void init(Product p) {
        List<Property> pts = propertyService.listProperty(p.getCid());

        for (Property pt : pts) {
            PropertyValue pv = getPropertyValueById(pt.getId(), p.getId());
            if (null == pv) {
                pv = new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                propertyValueMapper.insert(pv);
            }
        }

    }

}
