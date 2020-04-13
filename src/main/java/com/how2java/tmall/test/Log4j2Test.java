package com.how2java.tmall.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {

    String name;
    private static Logger logger = LogManager.getLogger(Log4j2Test.class.getName());

    public static void main(String[] args) {

        Log4j2Test teemo = new Log4j2Test();
        teemo.name = "teemo";
        logger.debug("修改前的名字为：" + teemo.name);
        teemo.name = "提莫";
        logger.trace("修改后的名字为：" + teemo.name);
        logger.debug("修改后的名字为：" + teemo.name);
        logger.info("修改后的名字为：" + teemo.name);
        logger.warn("修改后的名字为：" + teemo.name);
        logger.error("修改后的名字为：" + teemo.name);
        logger.fatal("修改后的名字为：" + teemo.name);

    }

}
