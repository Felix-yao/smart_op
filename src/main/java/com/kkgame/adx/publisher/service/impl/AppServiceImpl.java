package com.kkgame.adx.publisher.service.impl;

import java.util.List;

import com.kkgame.adx.publisher.bean.AppVO;
import com.kkgame.adx.publisher.dao.AppDao;
import com.kkgame.adx.publisher.service.AppService;

public class AppServiceImpl implements AppService{

	private AppDao appDao;
	
	public AppDao getAppDao() {
		return appDao;
	}

	public void setAppDao(AppDao appDao) {
		this.appDao = appDao;
	}

	@Override
	public int createApp(AppVO appVO) throws Exception {
		return appDao.createApp(appVO);
	}

	@Override
	public void updateApp(AppVO appVO) throws Exception {
		appDao.updateApp(appVO);
	}

	@Override
	public List<AppVO> getAppVOList(AppVO appVO) throws Exception {
		return appDao.getAppVOList(appVO);
	}

	@Override
	public void updateAppStatus(AppVO appVO) throws Exception {
		appDao.updateAppStatus(appVO);
	}

	@Override
	public AppVO getAppVO(AppVO appVO) throws Exception {
		return appDao.getAppVO(appVO);
	}
	

}
