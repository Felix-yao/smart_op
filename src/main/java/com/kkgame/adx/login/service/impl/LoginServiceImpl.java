package com.kkgame.adx.login.service.impl;

import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.login.dao.LoginDao;
import com.kkgame.adx.login.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	private LoginDao loginDao;
	public LoginDao getLoginDao() {
		return loginDao;
	}
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public LoginUser getLoginUser(LoginUser loginUser) throws Exception {
		return loginDao.getLoginUser(loginUser);	
	}

}
