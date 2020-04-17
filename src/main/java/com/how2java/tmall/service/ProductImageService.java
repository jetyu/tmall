/**
 * @Title: ProductImageService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.ProductImage;

/**
 * @Name: ProductImageService
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
public interface ProductImageService {

    String TYPE_SINGLE = "type_single";
    String TYPE_DETAIL = "type_detail";

    void deleteProductImage(int id);

    void insertProductImage(ProductImage pi);

    List<ProductImage> listProductImage(int pid, String type);
}
