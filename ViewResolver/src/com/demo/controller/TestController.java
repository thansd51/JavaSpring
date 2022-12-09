package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.DataBean;


@Controller
public class TestController {

	@GetMapping("test1")
	public String test1() {
		
		return "test1";
	}
	
	@GetMapping("test2")
	public String test2(HttpServletRequest request) {
		
		request.setAttribute("dataOne", 700);
		request.setAttribute("dataTwo", 1200);
		
		return "test2";
	}
	
	@GetMapping("test3")
	public String test2(Model model) {
		
		model.addAttribute("value3", 300);
		model.addAttribute("value4", 400);
		
		return "test3";
	}
	
	@GetMapping("test4")
	public ModelAndView test4(ModelAndView mv) {
		mv.addObject("mvData1", 500);
		mv.addObject("mvData2", 600);
		
		return mv;
	}
	
	@PostMapping("test5")
	public String test5(DataBean bean) {
		
		return "test5";
	}
}
