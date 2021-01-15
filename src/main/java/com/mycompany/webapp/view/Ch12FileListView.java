package com.mycompany.webapp.view;


import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.mycompany.webapp.controller.Ch12Controller;

//자바코드로 json 응답 만들기!!!
@Component
public class Ch12FileListView extends AbstractView{
	private static final Logger logger = LoggerFactory.getLogger(Ch12Controller.class);
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		File uploadDir = new File("C:/Temp/upload");
		String[] fileNames = uploadDir.list();
		
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//JSON라이브러리에 있는 JSONArray을 사용
		JSONArray jsonArray = new JSONArray();
		for (String fileName: fileNames) {
			jsonArray.put(fileName);
		}
		
		String json = jsonArray.toString();
		logger.info(json);
		
		out.write(json); //json 보내주기
		out.flush();
		out.close();
	}

}
