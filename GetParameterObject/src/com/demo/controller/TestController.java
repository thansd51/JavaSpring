package com.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.beans.DataBean;

@Controller
public class TestController {

	@GetMapping("test1")
	public String test1(@RequestParam Map<String, String> map, @RequestParam(name = "data3") List<String> data3_list) {
		String data1 = map.get("data1");
		String data2 = map.get("data2");
		
		System.out.printf("data1 : %s\n", data1);
		System.out.printf("data2 : %s\n", data2);
	
		for(String data3 : data3_list) {
			System.out.printf("data3 : %s\n", data3);
		}
		return "result";
	}
	
	@GetMapping("test2")
	public String test2(DataBean bean) {
		
		System.out.printf("data1 : %d\n", bean.getData1());
		System.out.printf("data2 : %d\n", bean.getData2());

		for(int data3 : bean.getData3()) {
			System.out.printf("data3 : %d\n", data3);
		}
		return "result";
	}
	
}
