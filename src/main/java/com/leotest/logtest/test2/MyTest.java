package com.leotest.logtest.test2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {
	Logger log = LoggerFactory.getLogger(MyTest.class);
	
	public void print(String msg) {
		log.warn(msg);
	}
}
