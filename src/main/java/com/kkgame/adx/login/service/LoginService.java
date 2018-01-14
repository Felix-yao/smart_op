package com.kkgame.adx.login.service;

import com.kkgame.adx.login.bean.LoginUser;

public interface LoginService {
	
	LoginUser getLoginUser(LoginUser loginUser) throws Exception;

}
