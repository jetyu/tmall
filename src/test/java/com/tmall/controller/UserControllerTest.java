/**
 * @Title: CategoryController.java
 * @Description:
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.tmall.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.how2java.tmall.service.CategoryService;

/**
 * @Name: CategoryController
 * @Description: 分类页面的控制器
 * @Author Jet Yu
 * @Date 2020-04-13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
@Transactional(transactionManager = "transactionManager")
// 测试结束后事物是否回滚;默认true;
@Rollback(value = false)
public class UserControllerTest {

    /**
     * 自动装配
     */
    @Autowired
    CategoryService categoryService;

    /**
     * 定义logger
     */
    private final static Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void test_listUser() {
        try {
            mockMvc.perform(post("/admin_user_list")) // 执行请求
                .andExpect(model().attributeExists("us")) // 验证存储模型数据
                .andExpect(model().attributeExists("page")) // 验证存储模型数据
                .andExpect(view().name("admin/listUser")) // 验证viewName
                .andExpect(forwardedUrl("admin/listUser"))// 验证视图渲染时forward到的jsp
                .andExpect(status().isOk())// 验证状态码
                .andDo(print());
            logger.info("测试UserControllerTest");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
