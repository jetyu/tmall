/**
 * @Title: OrderItemService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-19
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;

/**
 * @Name: OrderItemService
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-19
 */
public interface OrderItemService {

    List<OrderItem> listOrderItem();

    void deleteOrderItem(int id);

    void insertOrderItem(OrderItem oi);

    void updateOrderItem(OrderItem oi);

    OrderItem getOrderItem(int id);

    /**
     *
     * @Title: fill
     * @Author Jet Yu
     * @Date 2020-04-19
     * @param os
     */
    void fill(List<Order> os);
}
