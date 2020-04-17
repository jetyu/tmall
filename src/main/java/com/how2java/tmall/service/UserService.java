/**
 * @Title: UserService.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.User;

/**
 * @Name: UserService
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
public interface UserService {
    /**
     * 只允许查询用户信息
     *
     * @Title: listUser
     * @Author Jet Yu
     * @Date 2020-04-17
     * @return
     */
    List<User> listUser();

}
