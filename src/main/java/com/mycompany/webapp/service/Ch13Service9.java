package com.mycompany.webapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Ch13Service9 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13Service9.class);
	
	@Value("${service.prop1}") private int prop1;
	private double prop2;
	private boolean prop3;
	private String prop4;
	
	public Ch13Service9() {}
	public Ch13Service9(@Value("${service.prop2}") double prop2, @Value("${service.prop3}") boolean prop3) {
		this.prop2 = prop2;
		this.prop3 = prop3;
	}
	
	@Value("${service.prop4}") 
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
