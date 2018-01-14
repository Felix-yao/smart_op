package com.kkgame.adx.login.dao;

import com.kkgame.adx.login.bean.LoginUser;

public interface LoginDao {

	LoginUser getLoginUser(LoginUser loginUser) throws Exception;
}
