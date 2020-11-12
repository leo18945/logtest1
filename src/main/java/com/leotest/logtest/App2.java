package com.leotest.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leotest.logtest.test2.MyTest;

/**
 * Hello world!
 *
 */
public class App2 {
    public static void main( String[] args ){
    	Logger log = LoggerFactory.getLogger(App2.class);
    	
        log.debug("warn message");
//        log.error("error message");
    	
    	Logger log2 = LoggerFactory.getLogger("what.the.fuck.logger");
    	log2.debug("new message");
    	
    	Logger log3 = LoggerFactory.getLogger("whatthefucklogger");
    	log3.debug("whatthefucklogger message");
    }
}

/**
log4j.dao=info
log4j.com=error
log4j.root=warn

log.debug
log.info 1
log.warn 2
log.error 3
*/