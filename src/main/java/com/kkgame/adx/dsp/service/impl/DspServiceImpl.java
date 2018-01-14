package com.kkgame.adx.dsp.service.impl;

import java.util.List;

import com.kkgame.adx.dsp.bean.DspVO;
import com.kkgame.adx.dsp.dao.DspDao;
import com.kkgame.adx.dsp.service.DspService;

public class DspServiceImpl implements DspService{

	private DspDao dspDao;
	@Override
	public List<DspVO> selectAll(DspVO dspVO) {
		return dspDao.selectAll(dspVO);
	}
	public DspDao getDspDao() {
		return dspDao;
	}
	public void setDspDao(DspDao dspDao) {
		this.dspDao = dspDao;
	}
	@Override
	public void insertDsp(DspVO dspVO) {
		dspDao.insertDsp(dspVO);
		
	}
	@Override
	public void updateDsp(DspVO dspVO) {
		dspDao.updateDsp(dspVO);
	}
	@Override
	public DspVO selectDspById(DspVO dspVO) {
		return dspDao.selectDspById(dspVO);
	}
	@Override
	public List<DspVO> selectIdName(DspVO dspVO) throws Exception {
		return dspDao.selectIdName(dspVO);
	}
	@Override
	public void updateDspStatus(DspVO dspVO) throws Exception {
		dspDao.updateDspStatus(dspVO);
	}

	
}
