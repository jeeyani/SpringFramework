package com.mycompany.webapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycompany.webapp.dto.Ch07Board;

@Controller
@RequestMapping("/ch07")
public class Ch07Controller {

	private static final Logger logger = LoggerFactory.getLogger(Ch07Controller.class);
	
	
	@RequestMapping("/content")
	public String content() {
		return "ch07/content";
	}
	
	@GetMapping("/method1")
	public ModelAndView method1() {
		
		Ch07Board board = new Ch07Board(1,"집","나 진짜 기억안나","박지연",new Date());
		ModelAndView mav = new ModelAndView();
		mav.addObject("board1",board);
		mav.setViewName("ch07/boardDetail1");
		
		return mav;
	}
	
	@GetMapping("/method2")
	public String method2(Model model) {
		
		Ch07Board board = new Ch07Board(1,"집","나 진짜 기억안나","박지연",new Date());
		model.addAttribute("board2",board);
		model.addAttribute("board3",board);
		
		return "ch07/boardDetail2";
		
	}
	
	@ModelAttribute("board3")
	public Ch07Board getBoard() {
		Ch07Board board = new Ch07Board(1,"집","나 진짜 기억안나","박지연",new Date());
		return board ;
	}
	
	@RequestMapping("/method3")
	public String method3() {
		return "ch07/boardDetail3";
	}
	
	@PostMapping("/method4")
	public String method4(Ch07Board board) {
		
		return "ch07/boardDetail4";
	}
	
	@GetMapping("/method5")
	public String method5(Model model) {
		List<Ch07Board> list = new ArrayList<>();
		for (int i = 1; i <=5; i++) {
			list.add(new Ch07Board(i, "제목"+i, "내용"+i, "글쓴이"+i, new Date()));
		}
		
		model.addAttribute("list",list);
		
		return "ch07/boardList";
	}
}
