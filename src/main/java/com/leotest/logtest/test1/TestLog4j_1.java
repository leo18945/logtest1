package com.leotest.logtest.test1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class TestLog4j_1 {
	
	private static Logger logger = Logger.getLogger(TestLog4j_1.class);
    public static void main(String[] a) throws InterruptedException {
        BasicConfigurator.configure();
        logger.setLevel(Level.DEBUG);  //设置显示级别
        
        logger.trace("跟踪信息"); //所以这里是不会在控制台打印的 
        logger.debug("调试信息");
        logger.info("输出信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
    }
}
