package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.beans.DataBean;
import com.demo.mapper.MapperInterface;

@Controller
public class TestController {

	@Autowired
	MapperInterface mapper;

	@GetMapping("input_data")
	public String input_data() {

		return "input_data";
	}

	@PostMapping("input_pro")
	public String input_pro(DataBean dataBean) {
		mapper.insert_data(dataBean);

		return "input_pro";
	}

	@GetMapping("read_data")
	public String read_data(Model model) {

		List<DataBean> list = mapper.select_data();

		model.addAttribute("datas", list);

		return "read_data";
	}

}
