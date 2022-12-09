package com.demo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.beans.Product;
import com.demo.beans.User;

@Controller
public class TestController {
	
	@GetMapping("input_data")
	public String input_data() {
		
		return "input_data";
	}
	
	@PostMapping("input_pro")
	public String input_pro(@Valid User user, BindingResult result) {
		
		//System.out.printf("ID : %s\n", user.getId());
		//System.out.printf("Pass : %s\n", user.getPass());
		
		System.out.printf("BindingResult : %s\n", result);

		if(result.hasErrors()) {
			//유효성 검사에서 에러가 발생했을경우 다시 입력데이터 jsp페이지로 이동 이때 에러메세지 포함
			return "input_data";
		}
		
		return "input_success";
	}
	
	@GetMapping("input_product")
	public String input_product(Product product) {
		
		return "input_product";
	}
	
	@PostMapping("input_product_proc")
	public String input_product(@Valid Product product, BindingResult result) {
		
	
		if(result.hasErrors()) {
			return "input_product";
		}
		
		System.out.println(product.toString());
		
		return "input_product_success";
	}
}
