package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.demo.beans.DataBean;
import com.demo.beans.UserDataBean;


@Controller
public class TestController {

	@GetMapping("test1")
	public String test1(UserDataBean user) {
		
		user.setUser_name("홍길동");
		user.setUser_id("abcd");
		user.setUser_pw("1234");
		user.setUser_postcode("12345");
		user.setUser_address1("주소1번입니다");
		user.setUser_address2("주소 2번입니다");

		return "test1";
	}
	
	@GetMapping("test2")
	public String test2(UserDataBean user) {
		user.setUser_name("홍길동");
		user.setUser_id("abcd");
		user.setUser_pw("1234");
		user.setUser_postcode("12345");
		user.setUser_address1("주소1번입니다");
		user.setUser_address2("주소 2번입니다");
		
		return "test2";
	}
	
	@GetMapping("test3")
	public String test3(DataBean bean) {
		
		bean.setA1("select2");
		String[] list = {"check1", "check2"};
		bean.setA2(list);
		bean.setA3("radio2");
		
		return "test3";
	}
	
}
