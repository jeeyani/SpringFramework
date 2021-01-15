package com.mycompany.webapp.service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13BoardDao;

@Service
public class Ch13Service10 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13Service10.class);
	
	//@Autowired @Qualifier("Ch13BoardDao5Qualifier")
	//@Resource(name="ch13BoardDao5")
	@Inject @Named("ch13BoardDao5")
	private Ch13BoardDao dao1;
	
	//@Autowired @Qualifier("Ch13BoardDao6Qualifier")
	//@Resource(name="ch13BoardDao6")
	@Inject @Named("ch13BoardDao6")
	private Ch13BoardDao dao2;
	
	public void method() {
		dao1.method();
		dao2.method();
	}
	
}
