package com.mycompany.webapp.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.webapp.dao.Ch13BoardDao1;
import com.mycompany.webapp.dao.Ch13BoardDao2;
import com.mycompany.webapp.dao.Ch13BoardDao3;

@Service
public class Ch13Service6 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13Service6.class);
	

	@Resource private Ch13BoardDao1 dao1;
	@Resource private Ch13BoardDao2 dao2;
	private Ch13BoardDao3 dao3;
	
	
	//@Resource는 생성자에는 사용할 수 없음
	/*@Resource
	public Ch13Service6(Ch13BoardDao2 dao2) {
		this.dao2 = dao2;
	}*/
	
	
	@Resource
	public void setDao3(Ch13BoardDao3 dao3) {
		this.dao3 = dao3;
	}

	

	public void method() {
		logger.info("실행");
		dao1.method();
		dao2.method();
		dao3.method();
	}
	
	
	
}
