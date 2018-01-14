package com.kkgame.adx.publisher.dao;

import java.util.List;

import com.kkgame.adx.publisher.bean.AppVO;

public interface AppDao {
	
	int createApp(AppVO appVO) throws Exception;
	void updateApp(AppVO appVO) throws Exception;
	List<AppVO> getAppVOList(AppVO appVO) throws Exception;
	void updateAppStatus(AppVO appVO) throws Exception;
	AppVO getAppVO(AppVO appVO) throws Exception;
	
}
