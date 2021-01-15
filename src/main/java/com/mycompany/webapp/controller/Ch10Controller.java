package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.webapp.dto.Ch07Board;
import com.mycompany.webapp.dto.Ch08InputForm;
import com.mycompany.webapp.exception.notFoundAccountException;

@Controller
@RequestMapping("/ch10")

public class Ch10Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch10Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch10/content";
	}
	
	
	@GetMapping("/runtimeException")
	public String runtimeException() {
		
		String str = null;
		int size = str.length();
		
		return "ch10/content";
	}
	
	@GetMapping("/customException")
	public String customException() {
		
		if(true) {
			findAccount();
		}
	
		return "ch10/content";
	}
	
	public boolean findAccount() throws notFoundAccountException{
		if (true) {
			throw new notFoundAccountException("입금 내역이 없슈");
		}
		
		return true;
	}
	
}
