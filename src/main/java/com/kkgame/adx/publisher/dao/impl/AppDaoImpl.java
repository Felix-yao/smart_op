package com.kkgame.adx.publisher.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.publisher.bean.AppVO;
import com.kkgame.adx.publisher.dao.AppDao;

public class AppDaoImpl extends SqlMapClientDaoSupport implements AppDao{

	@Override
	public int createApp(AppVO appVO) throws Exception {
		return (int)getSqlMapClientTemplate().insert("appSqlMap.createApp", appVO);
	}

	@Override
	public void updateApp(AppVO appVO) throws Exception {
		getSqlMapClientTemplate().update("appSqlMap.updateApp", appVO);
	}

	@Override
	public List<AppVO> getAppVOList(AppVO appVO) throws Exception {
		int count = (int) getSqlMapClientTemplate().queryForObject("appSqlMap.getAppListCount", appVO);
		appVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("appSqlMap.getAppVOList", appVO);
	}

	@Override
	public void updateAppStatus(AppVO appVO) throws Exception {
		getSqlMapClientTemplate().update("appSqlMap.updateAppStatus", appVO);
	}

	@Override
	public AppVO getAppVO(AppVO appVO) throws Exception {
		return (AppVO) getSqlMapClientTemplate().queryForObject("appSqlMap.getAppVO", appVO);
	}

	

}
