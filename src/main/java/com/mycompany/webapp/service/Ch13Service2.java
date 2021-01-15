package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mycompany.webapp.dao.Ch13BoardDao1;
import com.mycompany.webapp.dao.Ch13BoardDao4;

public class Ch13Service2 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13Service2.class);
	
	private Ch13BoardDao1 dao1;
	private int value1;
	
	//생성자 주입
	public Ch13Service2(Ch13BoardDao1 dao1, int value1) {
		logger.info("실행");
		this.dao1 = dao1;
		this.value1 = value1;
	}
	
	
}
