package com.how2java.tmall.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @Name: Log4j2Test
 * @Description: Log4j2的测试类
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public class Log4j2Test {

    String name;
    private static Logger logger = LogManager.getLogger(Log4j2Test.class.getName());

    public static void main(String[] args) {

        Log4j2Test logObj = new Log4j2Test();
        logObj.name = "log4j2输出等级测试";
        logger.info("当前log4j.xml配置输出的level为：" + logger.getLevel());

        logger.debug("测试输出： " + logObj.name);
        logger.trace("测试输出： " + logObj.name);
        logger.debug("测试输出： " + logObj.name);
        logger.info("测试输出： " + logObj.name);
        logger.warn("测试输出： " + logObj.name);
        logger.error("测试输出： " + logObj.name);
        logger.fatal("测试输出： " + logObj.name);

    }

}
