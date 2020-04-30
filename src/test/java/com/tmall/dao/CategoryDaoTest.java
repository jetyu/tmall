package com.tmall.dao;

import static org.junit.Assert.assertNotNull;

import javax.annotation.Resource;

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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.how2java.tmall.mapper.CategoryMapper;
import com.how2java.tmall.pojo.Category;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/applicationContext.xml"})
@Rollback(value = true)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional(transactionManager = "transactionManager")
public class CategoryDaoTest {

    private static Logger logger = Logger.getLogger(CategoryDaoTest.class);
    @Autowired
    protected WebApplicationContext wac;
    @Resource
    CategoryMapper categoryMapper;

    @Before
    public void setUp() throws Exception {
        assertNotNull(wac);
        assertNotNull(categoryMapper);
    }

    @After
    public void tearDown() throws Exception {}

    @Test
    public void test_001_selectByPrimaryKeyTest() {
        Category c = categoryMapper.selectByPrimaryKey(146);
        logger.info(c.getId() + "-----" + c.getName());
        Assert.assertEquals("如果打印本信息, 证明参数不相等", 146, 146);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", "测试添加数据", c.getName());

    }

    @Test
    public void test_002_deleteByPrimaryKeyTest() {
        Category c = new Category();
        categoryMapper.deleteByPrimaryKey(146);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", 146, 146);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", null, c.getName());
    }

    @Test
    public void test_003_insertSelectiveTest() {
        Category c = new Category();
        c.setName("阿里巴巴");
        categoryMapper.insertSelective(c);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", "阿里巴巴", c.getName());
    }

    @Test
    public void test_004_updateByPrimaryKeySelectiveTest() {
        Category c = categoryMapper.selectByPrimaryKey(146);
        c.setName("更新测试");
        categoryMapper.updateByPrimaryKeySelective(c);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", 146, 146);
        Assert.assertEquals("如果打印本信息, 证明参数不相等", "更新测试", c.getName());
    }

}