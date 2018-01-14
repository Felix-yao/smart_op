package com.kkgame.adx.data.dao;

import java.util.List;

import com.kkgame.adx.data.bean.SilverDataVO;

public interface SilverDataDao {
	
	List<SilverDataVO> getPublisherData(SilverDataVO silverDataVO) throws Exception;
	
	List<SilverDataVO> getAllData(SilverDataVO silverDataVO) throws Exception;

}
