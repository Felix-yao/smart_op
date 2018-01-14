package com.kkgame.adx.order.service.impl;

import java.util.List;

import com.kkgame.adx.order.bean.SilverVO;
import com.kkgame.adx.order.dao.SilverDao;
import com.kkgame.adx.order.service.SilverService;

public class SilverServiceImpl implements SilverService{
	
	private SilverDao silverDao;

	public SilverDao getSilverDao() {
		return silverDao;
	}

	public void setSilverDao(SilverDao silverDao) {
		this.silverDao = silverDao;
	}

	@Override
	public List<SilverVO> listSilveVO(SilverVO silverVO) throws Exception {
		return silverDao.listSilveVO(silverVO);
	}

	@Override
	public void updateLogisticsNumber(SilverVO silverVO) throws Exception {
		silverDao.updateLogisticsNumber(silverVO);
	}

	@Override
	public void updateStatus(SilverVO silverVO) throws Exception {
		silverDao.updateStatus(silverVO);
	}

	@Override
	public SilverVO getSilverVO(SilverVO silverVO) throws Exception {
		return silverDao.getSilverVO(silverVO);
	}

}
