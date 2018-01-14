package com.kkgame.adx.data.service.impl;

import java.util.List;

import com.kkgame.adx.data.bean.SilverDataVO;
import com.kkgame.adx.data.dao.SilverDataDao;
import com.kkgame.adx.data.service.SilverDataService;

public class SilverDataServiceImpl implements SilverDataService{
	
	private SilverDataDao silverDataDao;
	
	public SilverDataDao getSilverDataDao() {
		return silverDataDao;
	}

	public void setSilverDataDao(SilverDataDao silverDataDao) {
		this.silverDataDao = silverDataDao;
	}

	@Override
	public List<SilverDataVO> getPublisherData(SilverDataVO silverDataVO) throws Exception {
		return silverDataDao.getPublisherData(silverDataVO);
	}

	@Override
	public List<SilverDataVO> getAllData(SilverDataVO silverDataVO) throws Exception {
		return silverDataDao.getAllData(silverDataVO);
	}

}
