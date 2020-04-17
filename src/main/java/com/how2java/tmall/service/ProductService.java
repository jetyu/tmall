/**
 * @Title: ProductService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;

/**
 * @Name: ProductService
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-16
 */
public interface ProductService {

    List<Product> listProduct(int cid);

    void insertProduct(Product p);

    void deleteProduct(int id);

    Product getProductById(int id);

    void updateProduct(Product p);

}
