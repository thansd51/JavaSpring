package com.demo.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("save_cookie")
	public String save_cookie(HttpServletResponse response) {

		try {
			// 쿠키에 입력되는 한글은 UTF-8로 Encoding
			String data1 = URLEncoder.encode("문자열13", "UTF-8");
			String data2 = URLEncoder.encode("문자열23", "UTF-8");

			Cookie cookie1 = new Cookie("cookie1", data1);
			Cookie cookie2 = new Cookie("cookie2", data2);

			// 쿠키 생성 시간 (초단위) - 일 / 시간 / 분 / 초
			cookie1.setMaxAge(365 * 24 * 60 * 60);
			cookie2.setMaxAge(365 * 24 * 60 * 60);

			response.addCookie(cookie1);
			response.addCookie(cookie2);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "save_cookie";
	}

	@GetMapping("load_cookie")
	public String load_cookie(HttpServletRequest request) {

		try {

			Cookie[] cookies = request.getCookies();

			for (Cookie cookie : cookies) {
				String str = URLDecoder.decode(cookie.getValue(), "UTF-8");

				if (cookie.getName().equals("cookie1")) {
					System.out.printf("cookie1 : %s\n", str);
				} else if (cookie.getName().equals("cookie2")) {
					System.out.printf("cookie2 : %s\n", str);
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "load_cookie";
	}

}
