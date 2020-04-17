/**
 * @Title: ProductImageService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.ProductImageMapper;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.pojo.ProductImageExample;
import com.how2java.tmall.service.ProductImageService;

/**
 * @Name: ProductImageService
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    ProductImageMapper productImageMapper;

    /**
     * @Title: deleteProductImage
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param id
     * @see com.how2java.tmall.service.ProductImageService#deleteProductImage(int)
     */
    @Override
    public void deleteProductImage(int id) {
        productImageMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Title: insertProductImage
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param pi
     * @see com.how2java.tmall.service.ProductImageService#insertProductImage(com.how2java.tmall.pojo.ProductImage)
     */
    @Override
    public void insertProductImage(ProductImage pi) {
        productImageMapper.insertSelective(pi);

    }

    /**
     * @Title: listProductImage
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param pid
     * @param type
     * @return
     * @see com.how2java.tmall.service.ProductImageService#listProductImage(int, java.lang.String)
     */
    @Override
    public List<ProductImage> listProductImage(int pid, String type) {
        ProductImageExample example = new ProductImageExample();
        example.createCriteria().andPidEqualTo(pid).andTypeEqualTo(type);
        example.setOrderByClause("pid desc");
        return productImageMapper.selectByExample(example);
    }

    /**
     * @Title: getProductImageById
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @param id
     * @return
     * @see com.how2java.tmall.service.ProductImageService#getProductImageById(int)
     */
    @Override
    public ProductImage getProductImageById(int id) {
        return productImageMapper.selectByPrimaryKey(id);
    }

}
