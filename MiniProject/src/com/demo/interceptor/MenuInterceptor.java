package com.demo.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.demo.beans.BoardInfoBean;
import com.demo.service.MenuService;

public class MenuInterceptor implements HandlerInterceptor {

	private MenuService menuSerivce;

	public MenuInterceptor(MenuService menuSerivce) {
		this.menuSerivce = menuSerivce;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 테이블에서 게시판 이름들을 가져와 메뉴에 적용
		List<BoardInfoBean> topMenuList = menuSerivce.getMenuList();
		request.setAttribute("topMenuList", topMenuList);

		return true;
	}

}
