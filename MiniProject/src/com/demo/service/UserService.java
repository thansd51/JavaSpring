package com.demo.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.LoginUserBean;
import com.demo.beans.UserBean;
import com.demo.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public boolean checkuserIdExist(String user_id) {

		String user_name = userMapper.checkUserIdExist(user_id);

		if (user_name == null) {
			return true;
		} else {
			return false;
		}

	}

	public void addUserInfo(UserBean joinUserBean) {
		userMapper.addUserInfo(joinUserBean);
	}

	
	@Resource(name = "loginUserBean")
	private LoginUserBean loginUserBean;
	
	public void getLoginUserInfo(LoginUserBean loginBean) {

		LoginUserBean tempLoginBean = userMapper.getLoginUserInfo(loginBean);

		if (tempLoginBean != null) {
			loginUserBean.setUser_idx(tempLoginBean.getUser_idx());
			loginUserBean.setUser_name(tempLoginBean.getUser_name());
			loginUserBean.setUserLogin(true); // 로그인 상태 true
		}
	}

}
