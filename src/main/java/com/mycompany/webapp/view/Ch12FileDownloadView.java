package com.mycompany.webapp.view;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//어노테이션 @Component을 사용하면 식별이름(클래스이름과 동일)을 가진 객체가 만들어짐 
@Component
public class Ch12FileDownloadView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//컨트롤러(ch09)에서 전달한 filename 얻기
		String fileName = (String) model.get("fileName");
		
		
		//파일의 데이터를 읽기 위한 입력 스트림 얻기
		String saveFilePath = "C:/Temp/upload/"+fileName;
		InputStream is = new FileInputStream(saveFilePath);
		
		//[응답 HTTP 헤더 구성]
		//1. content type 헤더 구성(파일의 종류) -  브라우저가 어떤  프로그램이 실행될지 알기 위해서 
		ServletContext application = request.getServletContext(); 
		String fileType = application.getMimeType(fileName);
		response.setContentType(fileType);
		
		//2. content Disposition 헤더 구성 (다운로드할 파일의 이름 지정)
		String OriginalFileName = fileName.split("_")[1]; // 숫자[0] _ 실제이름[1]
		//헤더에서는 한글을 그대로 전달할 수 없음으로 파일이름이 한글이면 아스키코드(ISO-8859-1)로 변환하기 위해서 사용
		OriginalFileName = new String(OriginalFileName.getBytes("UTF-8"),"ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\""+OriginalFileName+"\"");
		
		
		//3.Content-length 헤더 구성(다운로드할 파일의 크기 지정)
		int filesize = (int) new File(saveFilePath).length();
		response.setContentLength(filesize);
		
		//[응답HTTP의 바디(본문) 구성] - 입출력 스트림 사용(문자타입기반)
		OutputStream os = response.getOutputStream();
		FileCopyUtils.copy(is, os);// is에서 읽어서 os로 보냄
		
		os.flush();
		os.close();
		is.close();
				
		
		
	}

}
