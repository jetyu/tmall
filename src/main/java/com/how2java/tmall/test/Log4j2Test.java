package com.how2java.tmall.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 * @Name: Log4j2Test
 * @Description: TODO(Log4j2的测试)
 * @Author Jet Yu
 * @Date 2020-04-13
 */
public class Log4j2Test {

    String name;
    private static Logger logger = LogManager.getLogger(Log4j2Test.class.getName());

    public static void main(String[] args) {

        Log4j2Test logObj = new Log4j2Test();
        logObj.name = "1.测试log4j2";
        logger.debug("修改前的名字为：" + logObj.name);
        logObj.name = "2.测试log4j2 ";
        logger.trace("修改后的名字为：" + logObj.name);
        logger.debug("修改后的名字为：" + logObj.name);
        logger.info("修改后的名字为：" + logObj.name);
        logger.warn("修改后的名字为：" + logObj.name);
        logger.error("修改后的名字为：" + logObj.name);
        logger.fatal("修改后的名字为：" + logObj.name);

    }

}
