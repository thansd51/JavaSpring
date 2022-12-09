package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		return "test1";
	}
	
	@GetMapping("test2")
	public String test2() {
		return "test2";
	}
}
