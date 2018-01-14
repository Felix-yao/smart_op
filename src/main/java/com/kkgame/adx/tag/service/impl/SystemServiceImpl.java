package com.kkgame.adx.tag.service.impl;

import java.util.List;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.tag.bean.CountryVO;
import com.kkgame.adx.tag.bean.NameVO;
import com.kkgame.adx.tag.bean.Select2VO;
import com.kkgame.adx.tag.dao.SystemDao;
import com.kkgame.adx.tag.service.SystemService;

public class SystemServiceImpl extends BaseAction implements SystemService {

	private SystemDao systemDao;

	public SystemDao getSystemDao() {
		return systemDao;
	}

	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}

	@Override
	public List<NameVO> getAllAmList(NameVO nameVO) throws Exception {
		return systemDao.getAllAmList(nameVO);
	}

	@Override
	public List<CountryVO> getCountryList() throws Exception {
		return systemDao.getCountryList();
	}

	@Override
	public List<Select2VO> getDspSelect2(NameVO nameVO) throws Exception {
		return systemDao.getDspSelect2(nameVO);
	}

	@Override
	public List<Select2VO> getPublisherSelect2(NameVO nameVO) throws Exception {
		return systemDao.getPublisherSelect2(nameVO);
	}

	@Override
	public List<NameVO> getAllIAB1List() throws Exception {
		return systemDao.getAllIAB1List();
	}

	@Override
	public List<NameVO> getIAB2List(NameVO nameVO) throws Exception {
		return systemDao.getIAB2List(nameVO);
	}

	@Override
	public List<Select2VO> getAppSelect2(NameVO nameVO) throws Exception {
		return systemDao.getAppSelect2(nameVO);
	}

	@Override
	public List<Select2VO> getADPositionSelect2(NameVO nameVO) throws Exception {
		return systemDao.getADPositionSelect2(nameVO);
	}

	@Override
	public List<Select2VO> getCountrySelect2(NameVO nameVO) throws Exception {
		return systemDao.getCountrySelect2(nameVO);
	}

}
