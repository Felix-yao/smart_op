package com.kkgame.adx.dsp.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.dsp.bean.DspVO;
import com.kkgame.adx.dsp.dao.DspDao;

public class DspDaoImpl extends SqlMapClientDaoSupport implements DspDao {

	@Override
	public List<DspVO> selectAll(DspVO dspVO) {
		int count = (int) getSqlMapClientTemplate().queryForObject("dspSqlMap.getDspListCount", dspVO);
		dspVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("dspSqlMap.selectAll", dspVO);
	}

	@Override
	public void insertDsp(DspVO dspVO) {
		int id = (int) getSqlMapClientTemplate().insert("dspSqlMap.insertDspVO", dspVO);
		dspVO.setId(id);
		getSqlMapClientTemplate().insert("dspSqlMap.insertDspVOUser", dspVO);
	}

	@Override
	public void updateDsp(DspVO dspVO) {
		getSqlMapClientTemplate().update("dspSqlMap.updateDspVO", dspVO);
		getSqlMapClientTemplate().update("dspSqlMap.updateDspVOUser", dspVO);
	}

	@Override
	public DspVO selectDspById(DspVO dspVO) {
		return (DspVO) getSqlMapClientTemplate().queryForObject("dspSqlMap.selectDspById", dspVO);
	}

	@Override
	public List<DspVO> selectIdName(DspVO dspVO) {
		return getSqlMapClientTemplate().queryForList("dspSqlMap.selectIdName", dspVO);
	}

	@Override
	public void updateDspStatus(DspVO dspVO) {
		getSqlMapClientTemplate().update("dspSqlMap.updateDspStatus", dspVO);
	}

}
