package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {
	
	@GetMapping("test2")
	public String test2(Model model) {
		
		int [] array1 = {10, 20, 30};
		model.addAttribute("array", array1[10]);

//		ArrayList<String> list = null;
//		list.add("문자열");
		
		return "test2";
	}

}
