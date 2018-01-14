package com.kkgame.adx.data.service;

import java.util.List;

import com.kkgame.adx.data.bean.SilverDataVO;

public interface SilverDataService {
	
	List<SilverDataVO> getPublisherData(SilverDataVO silverDataVO) throws Exception;
	
	List<SilverDataVO> getAllData(SilverDataVO silverDataVO) throws Exception;
	
}
