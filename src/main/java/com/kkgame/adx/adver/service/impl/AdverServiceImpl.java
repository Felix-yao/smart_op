package com.kkgame.adx.adver.service.impl;

import java.util.List;

import com.kkgame.adx.adver.bean.AdverVO;
import com.kkgame.adx.adver.dao.AdverDao;
import com.kkgame.adx.adver.service.AdverService;

public class AdverServiceImpl implements AdverService{

	private AdverDao adverDao;
	@Override
	public List<AdverVO> selectAll(AdverVO adverVO) throws Exception {
		return adverDao.selectAll(adverVO);
	}
	public AdverDao getAdverDao() {
		return adverDao;
	}
	public void setAdverDao(AdverDao adverDao) {
		this.adverDao = adverDao;
	}
	@Override
	public void updateAdverStatus(AdverVO adverVO) throws Exception {
		adverDao.updateAdverStatus(adverVO);
	}
	@Override
	public AdverVO selectAdverById(AdverVO adverVO) throws Exception {
		return adverDao.selectAdverById(adverVO);
	}
	@Override
	public void insertAdver(AdverVO adverVO) throws Exception {
		adverDao.insertAdver(adverVO);
	}
	@Override
	public void updateAdver(AdverVO adverVO) throws Exception {
		adverDao.updateAdver(adverVO);
	}

}
