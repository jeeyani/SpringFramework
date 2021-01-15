package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


public class Ch13Service8 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13Service8.class);
	
	private int prop1;
	private double prop2;
	private boolean prop3;
	private String prop4;
	
	public Ch13Service8(int prop1, double prop2) {
		this.prop1 = prop1;
		this.prop2 = prop2;
	}

	public void setProp3(boolean prop3) {
		this.prop3 = prop3;
	}

	public void setProp4(String prop4) {
		this.prop4 = prop4;
	}
	
	
	public void method() {
		logger.info("prop1: "+prop1);
		logger.info("prop2: "+prop2);
		logger.info("prop3: "+prop3);
		logger.info("prop4: "+prop4);
	}
	
	
}
