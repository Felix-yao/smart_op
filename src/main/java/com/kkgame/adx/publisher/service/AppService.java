package com.kkgame.adx.publisher.service;

import java.util.List;

import com.kkgame.adx.publisher.bean.AgentVO;
import com.kkgame.adx.publisher.bean.AppVO;

public interface AppService {

	int createApp(AppVO appVO) throws Exception;
	void updateApp(AppVO appVO) throws Exception;
	List<AppVO> getAppVOList(AppVO appVO) throws Exception;
	void updateAppStatus(AppVO appVO) throws Exception;
	AppVO getAppVO(AppVO appVO) throws Exception;
}
