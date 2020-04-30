/**
 * @Title: CategoryController.java
 * @Description:
 * @Author Jet Yu
 * @Date 2020-04-13
 */
package com.tmall.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
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
public class CategoryControllerTest {

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
        logger.info("测试test_listUser");
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/admin_category_list")) // 执行请求
                .andExpect(model().attributeExists("categoryList")) // 验证存储模型数据
                .andExpect(model().attributeExists("page")) // 验证存储模型数据
                .andExpect(view().name("admin/listCategory")) // 验证viewName
                .andExpect(forwardedUrl("admin/listCategory"))// 验证视图渲染时forward到的jsp
                .andExpect(status().isOk())// 验证状态码
                .andDo(print()).andReturn().getResponse().getContentAsString(); // 将数据转换为字符串
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_insertUser() {
        logger.info("测试test_insertUser");

        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/admin_category_add").param("name", "单体测试结果1")) // 执行请求
                .andExpect(model().attributeExists("category")) // 验证存储模型数据
                .andExpect(view().name("redirect:/admin_category_list")) // 验证viewName
                .andExpect(redirectedUrl("/admin_category_list"))// 验证视图渲染时redirect到的页面
                // .andExpect(status().isOk())// 验证状态码
                .andDo(print()).andReturn().getResponse().getContentAsString(); // 将数据转换为字符串
            //
            // ResultActions resultActions =
            // mockMvc.perform(MockMvcRequestBuilders.fileUpload("/tmall_ssm/img/category/") // 执行请求
            // .file(new MockMultipartFile("file", "1", "image/jpeg", new FileInputStream(new
            // File("/Users/Jet/Desktop/1.jpg")))));
            // MvcResult mvcResult =
            // resultActions.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            // String result = mvcResult.getResponse().getContentAsString();
            // logger.info("==========结果为：==========\n" + result + "\n");

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
