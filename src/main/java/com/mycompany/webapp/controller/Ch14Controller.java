package com.mycompany.webapp.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.webapp.dao.Ch14BoardDao;
import com.mycompany.webapp.dto.Ch14Board;
import com.mycompany.webapp.dto.Ch14Member;
import com.mycompany.webapp.dto.Ch14Pager;
import com.mycompany.webapp.service.Ch14Service;

@Controller
@RequestMapping("/ch14")
public class Ch14Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch14Controller.class);
	
	@RequestMapping("/content")
	public String content() {
		return "ch14/content";
	}	
	
	//datasource주입
	@Resource
	private DataSource dataSource;
	
	@GetMapping("/connTest")
	public String connTest() {
		
		try {
			//연결객체 대여
			Connection conn = dataSource.getConnection();
			
			//연결객체 반납
			conn.close();
			//로그출력
			logger.info("연결객체를 성공적으로 대여후 반납");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		/*	
			//---------------------게시판 넣을라고 쓰는거
			for (int i = 1; i <=1000; i++) {
				Ch14Board board = new Ch14Board();
				board.setBtitle("하품"+i);
				board.setBcontent("으아아아아아아"+i);
				board.setMid("aaaa");
				service.boardWrite(board);
				
			}
			//---------------------------------
			*/
		return "ch14/content";
	}
	
	//서비스 주입받음
	@Resource
	public Ch14Service service;
	
	
	@PostMapping("/join")
	public String join(Ch14Member member) throws IllegalStateException, IOException {
		if(!member.getMphotoAttach().isEmpty()) { //사진을 올렸을 경우
			//해당 파일을 사용자의 아이디로 저장하기
			String originalFileName = member.getMphotoAttach().getOriginalFilename();
			String extName = originalFileName.substring(originalFileName.lastIndexOf("."));
			String saveName = member.getMid()+extName;
		
			member.getMphotoAttach().transferTo(new File("D:/MyWokspace/photo/"+saveName));
			member.setMphoto(saveName);
			}else {
				member.setMphoto("unnamed.png");
			}
				

			member.setMenabled(true);
			member.setMrole("ROLE_USER");
			service.join(member);
		
		return "redirect:/ch14/content";
	}
	
	@PostMapping("/login")
	public String login(Ch14Member member, HttpSession session,Model model) {
		String result = service.login(member);
		
		if(result.equals("success")) {
			
			//로그인정보 유지(session에 저장)
			session.setAttribute("sessionMid", member.getMid());

			return "redirect:/ch14/content";
					
		}else { //wrongMid, wrongMpassword일 경우에 실행
			model.addAttribute("error",result);
			return "ch14/content";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/ch14/content";
	}
	
	/*
	 @GetMapping("/boardList")
	public String boardList(Model model) {
		
		List<Ch14Board> list = service.getBoardList();
		model.addAttribute("list",list);
		
		return "ch14/boardList";
	}
	*/
	
	@GetMapping("/boardList")
	public String boardList(@RequestParam(defaultValue = "1")int pageNo, Model model) {
	 //페이지 번호를 넘겨받음 (첫 실행시 값이 없음으로 1을 받아서 맨 첫페이지를 보여줌)
	 	int totalRows = service.getTotalRow();
	 	
		Ch14Pager pager = new Ch14Pager(10, 5, totalRows, pageNo);
		List<Ch14Board> list = service.getBoardList(pager);
		model.addAttribute("list",list);
		model.addAttribute("pager",pager);
		
		return "ch14/boardList";
	}
	
	//프로필 사진 가져오기
	@GetMapping("/photodownload")
	public void photodownload(String fileName, HttpServletResponse respone,HttpServletRequest request) throws Exception {
		logger.info(fileName);
		//파일의 데이터를 읽기 위한 입력 스트림 얻기
		String saveFilePath = "D:/MyWokspace/photo/"+fileName;
		InputStream is = new FileInputStream(saveFilePath);
		
		//[응답 HTTP 헤더 구성]
		//1. content type 헤더 구성(파일의 종류) -  브라우저가 어떤  프로그램이 실행될지 알기 위해서 
		ServletContext application = request.getServletContext(); 
		String fileType = application.getMimeType(fileName);
		respone.setContentType(fileType);
		
		//2. content Disposition 헤더 구성 (다운로드할 파일의 이름 지정)
		respone.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		
		
		//3.Content-length 헤더 구성(다운로드할 파일의 크기 지정)
		int filesize = (int) new File(saveFilePath).length();
		respone.setContentLength(filesize);
		
		//[응답HTTP의 바디(본문) 구성] - 입출력 스트림 사용(문자타입기반)
		OutputStream os = respone.getOutputStream();
		FileCopyUtils.copy(is, os);// is에서 읽어서 os로 보냄
		
		os.flush();
		os.close();
		is.close();
		
		
	}
	
	@GetMapping("/boardWrite")
	public String boardWriteForm() {
		
		return "ch14/boardWriteForm";
	}
	
	@PostMapping("/boardWrite")
	public void boardWrite(Ch14Board board,HttpServletResponse response) throws Exception {
		//게시물쓰기
		service.boardWrite(board);
		
		//json응답만들기
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString(); //{"result":"success"}
		
		//json보내기
		PrintWriter out = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		out.println(json);
		out.flush();
		out.close();
		
	}
	
	@GetMapping("/boardDetail")
	public String boardDetail(int bno,Model model) {
		Ch14Board board= service.getBoard(bno);
		model.addAttribute("board",board);
		
		return "ch14/boardDetail";
	}
	
	//게시물 삭제를 위한 json응답만들기
	@PostMapping("/boardDelete")
	public void boardDelete(int bno, HttpServletResponse response) throws Exception {
		//게시물 삭제 응답/요청
		service.boardDelete(bno);
		
		//json응답만들기
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString(); //{"result":"success"}
		
		//json보내기
		PrintWriter out = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		out.println(json);
		out.flush();
		out.close();

	}
	
	//글 수정 폼 요청하기
	@GetMapping("/boardUpdate")
	public String boardUpdateForm(int bno,Model model) {
		Ch14Board board = service.getBoard(bno);
		model.addAttribute("board",board);
		
		return "ch14/boardUpdateForm";
	}
	
	
	@PostMapping("/boardUpdate")
	public void boardUpdate(Ch14Board board,HttpServletResponse response) throws Exception {
		//게시물 수정
		service.boardUpdate(board);
		
		//json응답만들기
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		String json = jsonObject.toString(); //{"result":"success"}
		
		//json보내기
		PrintWriter out = response.getWriter();
		response.setContentType("application/json;charset=utf-8");
		out.println(json);
		out.flush();
		out.close();

	}
	
}
