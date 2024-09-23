package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.support.*;

import com.example.demo.dto.*;
import com.example.demo.service.*;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public ModelAndView index() {
		List<BoardDto> list = boardService.findAll();
		return new ModelAndView("index").addObject("result",list);
	}
	@GetMapping("/write")
	public ModelAndView writeget() {
		return new ModelAndView("write");
	}
	@PostMapping("/write")
	public ModelAndView writepost(String title,String content, String nickname, RedirectAttributes ra) {
		if(title.equals("")||content.equals("")||nickname.equals(""))
			ra.addFlashAttribute("message","제목,내용,닉네임은 필수입력입니다.");
		else
			boardService.save(title, content, nickname);
		return new ModelAndView("redirect:/");
	}
	
	
	public ModelAndView update() {
		return null;
	}
	
	public ModelAndView delete() {
		return null;
	}
}
