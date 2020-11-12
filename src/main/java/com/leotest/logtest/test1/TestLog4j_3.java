package com.leotest.logtest.test1;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.EnhancedPatternLayout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * 
 * 如果要想classpath:log4j.properties不生效，需要在vm options中增加以下配置
 * -Dlog4j.configuration=file:/full_path/log4j.properties
 */
public class TestLog4j_3 {
	static {
		Logger root = Logger.getRootLogger();
		root.setLevel(Level.INFO);
		ConsoleAppender appender = new ConsoleAppender(new EnhancedPatternLayout("[%-30.30c{1.}] %m%n"));
		appender.setName("console");
		root.addAppender(appender);
	}
	
	Logger log = Logger.getLogger(TestLog4j_3.class);
	
	public static void main(String[] args) {
		TestLog4j_3 test = new TestLog4j_3();
		test.log.info("good luck!");
		test.log.error("how are you!");
	}
}