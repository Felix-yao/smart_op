package com.kkgame.adx.publisher.service.impl;

import java.util.Date;
import java.util.List;

import com.kkgame.adx.publisher.bean.ADPositionVO;
import com.kkgame.adx.publisher.dao.ADPositionDao;
import com.kkgame.adx.publisher.service.ADPositionService;
import com.kkgame.adx.util.MD5Code;

public class ADPositionServiceImpl implements ADPositionService{
	
	private ADPositionDao adPositionDao;
	
	public ADPositionDao getAdPositionDao() {
		return adPositionDao;
	}

	public void setAdPositionDao(ADPositionDao adPositionDao) {
		this.adPositionDao = adPositionDao;
	}

	@Override
	public void createADPosition(ADPositionVO adPositionVO) throws Exception {
		MD5Code md5 =new MD5Code();
		String key=md5.getMD5ofStr(String.valueOf(new Date().getTime()));
		adPositionVO.setToken(key);
		adPositionDao.createADPosition(adPositionVO);
	}

	@Override
	public void updateADPosition(ADPositionVO adPositionVO) throws Exception {
		adPositionDao.updateADPosition(adPositionVO);
	}

	@Override
	public List<ADPositionVO> getADPositionList(ADPositionVO adPositionVO) throws Exception {
		return adPositionDao.getADPositionList(adPositionVO);
	}

	@Override
	public ADPositionVO getADPosition(ADPositionVO adPositionVO) throws Exception {
		return adPositionDao.getADPosition(adPositionVO);
	}

	@Override
	public void updateADPositionStatus(ADPositionVO adPositionVO) throws Exception {
		adPositionDao.updateADPositionStatus(adPositionVO);
	}

	

}
