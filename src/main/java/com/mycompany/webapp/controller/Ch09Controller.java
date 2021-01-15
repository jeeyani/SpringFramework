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

@Controller
@RequestMapping("/ch09")

public class Ch09Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch09Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch09/content";
	}
	
	@PostMapping("/boardUpload")
	public String boardUpload(String title, String content, MultipartFile attach) {
		
		logger.info(title);
		logger.info(content);
		
		
		if(!attach.isEmpty()) {
			String saveFileName = new Date().getTime()+"_"+attach.getOriginalFilename();
			
			try {
				attach.transferTo(new File("C:/Temp/upload/"+saveFileName));
			} catch (Exception e) {}
		}
		
		return "ch09/content";
	}
	
	@PostMapping("/boardUploadAjax")
	public String boardUploadAjax(String title, String content, MultipartFile attach) {
		
		logger.info(title);
		logger.info(content);
		
		
		if(attach !=null) {
			String saveFileName = new Date().getTime()+"_"+attach.getOriginalFilename();
			
			try {
				attach.transferTo(new File("C:/Temp/upload/"+saveFileName));
			} catch (Exception e) {}
		}
		
		return "ch09/content";
	}
	
	@GetMapping("/getFileList")
	public String getFileList(Model model) {
		File uploadDir = new File("C:/Temp/upload");
		String[] fileNames = uploadDir.list();
		model.addAttribute("fileNames",fileNames);
		
		return  "ch09/getFileList";
	}
	
	@GetMapping("/download")
	public void download(String fileName,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String saveFilePath = "C:/Temp/upload/"+fileName;
		InputStream is = new FileInputStream(saveFilePath);
		
		String fileType = request.getServletContext().getMimeType(fileName);
		response.setContentType(fileType);
		
		String originalFileName = fileName.split("_")[1];
		originalFileName = new String(originalFileName.getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\""+originalFileName+"\"");
		
		int fileSize = (int) new File(saveFilePath).length();
		response.setContentLength(fileSize);

		
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);
		
		os.flush();
		os.close();
		is.close();
	}
	
	
}
