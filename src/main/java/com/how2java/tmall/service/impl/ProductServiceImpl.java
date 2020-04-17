/**
 * @Title: ProductServiceImpl.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.ProductMapper;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductExample;
import com.how2java.tmall.service.ProductService;

/**
 * @Name: ProductServiceImpl
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    /**
     * @Title: listProduct
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param cid
     * @return
     * @see com.how2java.tmall.service.ProductService#listProduct(int)
     */
    @Override
    public List<Product> listProduct(int cid) {
        ProductExample example = new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        return productMapper.selectByExample(example);
    }

    /**
     * @Title: insertProduct
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param p
     * @see com.how2java.tmall.service.ProductService#insertProduct(com.how2java.tmall.pojo.Product)
     */
    @Override
    public void insertProduct(Product p) {
        productMapper.insertSelective(p);
    }

    /**
     * @Title: deleteProduct
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param id
     * @see com.how2java.tmall.service.ProductService#deleteProduct(int)
     */
    @Override
    public void deleteProduct(int id) {
        productMapper.deleteByPrimaryKey(id);
    }

    /**
     * @Title: getProductById
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param id
     * @return
     * @see com.how2java.tmall.service.ProductService#getProductById(int)
     */
    @Override
    public Product getProductById(int id) {
        return productMapper.selectByPrimaryKey(id);
    }

    /**
     * @Title: updateProduct
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-16
     * @param p
     * @see com.how2java.tmall.service.ProductService#updateProduct(com.how2java.tmall.pojo.Product)
     */
    @Override
    public void updateProduct(Product p) {
        productMapper.updateByPrimaryKeySelective(p);

    }

}
