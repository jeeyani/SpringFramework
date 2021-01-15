package com.mycompany.webapp.controller;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@RequestMapping("/ch06")
public class Ch06Controller {

	public static final Logger logger = LoggerFactory.getLogger(Ch06Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		logger.info("실행");
		return "ch06/content";
	}
	
	@GetMapping("/forward")
	public String forward(HttpServletRequest request) {
		
		String param1 = "무슨값이게";
		String param2 = "param2값은 이거지롱";
		
		request.setAttribute("param1",param1);
		request.setAttribute("param2",param2);
		
		return "ch06/forwarded";
	}
	
	@GetMapping("/redirect")
	public String redirect(HttpSession session) {
		
		String param1 = "이거 session";
		String param2 = "session은 param2";
		
		session.setAttribute("param1",param1);
		session.setAttribute("param2",param2);
		
		return "ch06/redirected";
	}
	
	
	
	
}
