/**
 * @Title: UserServiceImpl.java
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;

/**
 * @Name: UserServiceImpl
 * @Description: TODO(描述)
 * @Author Jet Yu
 * @Date 2020-04-17
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * @Title: listUser
     * @Description: TODO(描述)
     * @Author Jet Yu
     * @Date 2020-04-17
     * @return
     * @see com.how2java.tmall.service.UserService#listUser()
     */
    @Override
    public List<User> listUser() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

}
