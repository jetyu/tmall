package com.tmall.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Rollback(value = true)
@Transactional(transactionManager = "transactionManager")
public class CategoryServiceImplTest {

    private static Logger logger = Logger.getLogger(CategoryServiceImplTest.class);

    @Autowired
    CategoryService categoryService;

    @Before
    public void setUp() throws Exception {}

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test_001_DeleteCategory() {
        Category c = categoryService.getCategoryById(146);
        logger.info(c.getId() + " ----- " + c.getName());
        categoryService.deleteCategory(c.getId());
        Assert.assertEquals("如果打印本信息, 证明参数相等", 146, 146);
    }

    @Test
    public void test_002_ListCategory() {
        List<Category> c = categoryService.listCategory();
        for (Category category : c) {
            logger.info(category.getId() + "---" + category.getName());
        }
        logger.info("输出列表的数为：" + c.size());
        assertEquals(20, c.size());
    }

    @Test
    public void test_003_InsertCategory() {
        Category c = new Category();
        c.setName("你好-回滚测试");
        categoryService.insertCategory(c);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", "你好-回滚测试", c.getName());
    }

    @Test
    public void test_004_UpdateCategory() {
        Category c = categoryService.getCategoryById(143);
        logger.info(c.getId() + " ----- " + c.getName());
        c.setName("更新测试数据-带回滚");
        categoryService.updateCategory(c);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", "更新测试数据-带回滚", c.getName());
    }

}