package com.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;

	@GetMapping("login")
	public String login(@ModelAttribute("loginBean") LoginUserBean loginBean) {

		return "user/login";
	}

	@PostMapping("login_pro")
	public String login_pro(@Valid @ModelAttribute("loginBean") LoginUserBean loginBean, BindingResult result) {

		if (result.hasErrors()) {
			return "user/login";
		}

		userService.getLoginUserInfo(loginBean);

		if (loginUserBean.isUserLogin() == true) {
			return "user/login_success";
		} else {
			return "user/login_fail";
		}

	}

	@GetMapping("join")
	public String join(@ModelAttribute("joinUserBean") UserBean joinUserBean) {

		return "user/join";
	}

	@PostMapping("join_pro")
	public String join_pro(@Valid @ModelAttribute("joinUserBean") UserBean joinUserBean, BindingResult result) {

		if (result.hasErrors()) {

			return "user/join";
		}
		userService.addUserInfo(joinUserBean);

		return "user/join_success";
	}

	@GetMapping("modify")
	public String modify() {

		return "user/modify";
	}

	@GetMapping("logout")
	public String logout() {

		return "user/logout";
	}

}
