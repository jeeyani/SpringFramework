package com.mycompany.webapp.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;



import com.mycompany.webapp.dto.Ch04Member;
import com.mycompany.webapp.validation.Ch04MemberJoinFormValidator;
import com.mycompany.webapp.validation.Ch04MemberLoginFormValidator;

@Controller
@RequestMapping("/ch05")
public class Ch05Controller {

	public static final Logger logger = LoggerFactory.getLogger(Ch05Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch05/content";
	}
	
	@GetMapping("/method1")
	public String method1(@RequestHeader("User-Agent") String agent,HttpServletRequest request) {
		logger.info("실행");
		
		String browserkind = null;
		
		if(agent.contains("Chrome") && agent.contains("Edg") ) {
			browserkind = "Edg";
		} else if(agent.contains("Chrome") ) {
			browserkind = "Chrome";
		} else if(agent.contains("Trident/7.0") ) {
			browserkind = "IE11";
		} 
		
		request.setAttribute("browserkind",browserkind);
		
		return "ch05/content";
	}
	
	@GetMapping("/method2")
	public String method2(HttpServletResponse response) {
		
		Cookie cookie1 = new Cookie("mid", "jioye");
		Cookie cookie2 = new Cookie("memail", "jojo@naver.com");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		
		return "ch05/content";
	}
	
	@GetMapping("/method3")
	public String method3(@CookieValue String mid, @CookieValue("memail") String email, HttpServletRequest request) {
		
		request.setAttribute("mid", mid);
		request.setAttribute("memail", email);
		
		return "ch05/content";
	}
	
	
	
}
