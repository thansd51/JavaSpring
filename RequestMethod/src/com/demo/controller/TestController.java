package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@GetMapping("get")
	public String test1() {
		return "test1";
	}
	
	@PostMapping("post")
	public String test2() {
		return "test2";
	}
	
	@GetMapping("test3")
	public String test3_get() {
		return "test3_get";
	}
	
	@PostMapping("test3")
	public String test3_post() {
		return "test3_post";
	}
	
	@RequestMapping("test")
	public String test() {
		return "test";
	}
}
