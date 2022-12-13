package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.BoardInfoBean;
import com.demo.mapper.MenuMapper;

@Service
public class MenuService {
	// 게시판 정보 테이블에 연결해서 게시판 이름 가져오기
	@Autowired
	private MenuMapper menuMapper;
	
	public List<BoardInfoBean> getMenuList() {		
		List<BoardInfoBean> menuList = menuMapper.getMenuList();
		
		return menuList;
	}
	
}
