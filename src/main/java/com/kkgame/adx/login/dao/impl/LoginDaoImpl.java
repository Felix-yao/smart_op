package com.kkgame.adx.login.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.login.dao.LoginDao;

public class LoginDaoImpl extends SqlMapClientDaoSupport implements LoginDao {

	@Override
	public LoginUser getLoginUser(LoginUser loginUser) throws Exception {
		return (LoginUser) getSqlMapClientTemplate().queryForObject("loginSqlMap.getLoginUser", loginUser);
	}

}
