package com.mycompany.webapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ch13BoardDao3 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13BoardDao3.class);
	
	public Ch13BoardDao3 (String str) { //접근자와 상관없이 기본생성자를 만들 수 있음
		logger.info("실행");
	}
	
	public static Ch13BoardDao3 getInstance() {
		return new Ch13BoardDao3("매개값");
	}
	
	public void method() {
		logger.info("실행");
	}
}
