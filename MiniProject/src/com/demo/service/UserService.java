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

	// 현재 로그인중인 유저의 인덱스번호로 아이디와 이름을 얻어서 modifyUserBean 객체에 저장
	public void getModifyUserInfo(UserBean modifyUserBean) {
		UserBean temp = userMapper.getModifyUserInfo(loginUserBean.getUser_idx());

		modifyUserBean.setUser_id(temp.getUser_id());
		modifyUserBean.setUser_name(temp.getUser_name());
		modifyUserBean.setUser_idx(temp.getUser_idx());

	}

	public void modifyUserInfo(UserBean modifyUserBean) {

		modifyUserBean.setUser_idx(loginUserBean.getUser_idx());

		userMapper.modifyUserInfo(modifyUserBean);
	}
}
