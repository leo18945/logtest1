package com.leotest.logtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leotest.logtest.test2.MyTest;

/**
 * Hello world!
 *
 */
public class App {
	Logger log = LoggerFactory.getLogger(App.class);
	
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        
        //MyTest test1 = new MyTest();
        //test1.print("test1");
        
//        MyTest test2 = new MyTest();
//        test2.print("test2");
        
        App app1 = new App();
        //App app2 = new App();
        app1.log.warn("good luck!");
        app1.log.debug("", 1, 2, 3);//ok
        app1.log.info("", 1, 2, 3);
        app1.log.warn("", 1, 2, 3);
        app1.log.error("", 1, 2, 3);
        //app2.log.warn("bad idea!");
    }
}
