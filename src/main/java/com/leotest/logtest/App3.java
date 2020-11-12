package com.leotest.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leotest.logtest.test2.MyTest;

/**
 * Hello world!
 *
 */
public class App3 {
    public static void main( String[] args ){
    	Logger log = LoggerFactory.getLogger(App3.class);
    	
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.error("error");
    }
}