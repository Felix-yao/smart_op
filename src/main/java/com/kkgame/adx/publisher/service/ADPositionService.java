package com.kkgame.adx.publisher.service;

import java.util.List;

import com.kkgame.adx.publisher.bean.ADPositionVO;

public interface ADPositionService {

	void createADPosition(ADPositionVO adPositionVO) throws Exception;
	void updateADPosition(ADPositionVO adPositionVO) throws Exception;
	void updateADPositionStatus	 (ADPositionVO adPositionVO) throws Exception;
	List<ADPositionVO> getADPositionList(ADPositionVO adPositionVO) throws Exception;
	ADPositionVO getADPosition(ADPositionVO adPositionVO) throws Exception;
}
