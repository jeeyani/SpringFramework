package com.mycompany.webapp.controller;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.webapp.service.Ch13Service10;
import com.mycompany.webapp.service.Ch13Service5;
import com.mycompany.webapp.service.Ch13Service6;
import com.mycompany.webapp.service.Ch13Service7;
import com.mycompany.webapp.service.Ch13Service8;
import com.mycompany.webapp.service.Ch13Service9; 

@Controller
@RequestMapping("/ch13")
public class Ch13Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch13Controller.class);

	@Autowired
	private Ch13Service5 service5; //어노테이션 사용으로 인해 객체가 자동으로 주입됨
	
	@Resource
	private Ch13Service6 service6;
	
	@Inject
	private Ch13Service7 service7;
	
	@Resource
	private Ch13Service8 service8;
	
	@Resource
	private Ch13Service9 service9;
	
	@Resource
	private Ch13Service10 service10;
	
	@RequestMapping("/content")
	public String content() {
		return "ch13/content";
	}	
	
	@GetMapping("/useAutowired")
	public String useAutowired() {
		service5.method();
		return "ch13/content";
	}	
	
	@GetMapping("/useResource")
	public String useResource() {
		service6.method();
		return "ch13/content";
	}	
	
	@GetMapping("/useInject")
	public String useInject() {
		service7.method();
		return "ch13/content";
	}	
	
	@GetMapping("/usePropertiesXml")
	public String usePropertiesXml() {
		service8.method();
		return "ch13/content";
	}
	
	@GetMapping("/usePropertiesAnno")
	public String usePropertiesAnno() {
		service9.method();
		return "ch13/content";
	}
	
	@GetMapping("/useInterface")
	public String useInterface() {
		service10.method();
		return "ch13/content";
	}
}
