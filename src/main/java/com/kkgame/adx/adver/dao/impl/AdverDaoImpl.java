package com.kkgame.adx.adver.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.adver.bean.AdverVO;
import com.kkgame.adx.adver.dao.AdverDao;

public class AdverDaoImpl extends SqlMapClientDaoSupport implements AdverDao {

	@Override
	public List<AdverVO> selectAll(AdverVO adverVO) {
		int count = (int) getSqlMapClientTemplate().queryForObject("adverSqlMap.getAdverListCount", adverVO);
		adverVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("adverSqlMap.selectAll", adverVO);
	}

	@Override
	public void updateAdverStatus(AdverVO adverVO) {
		getSqlMapClientTemplate().update("adverSqlMap.updateAdverStatus", adverVO);
	}

	@Override
	public AdverVO selectAdverById(AdverVO adverVO) {
		return (AdverVO) getSqlMapClientTemplate().queryForObject("adverSqlMap.selectAdverById", adverVO);
	}

	@Override
	public void insertAdver(AdverVO adverVO) {
		int id = (int) getSqlMapClientTemplate().insert("adverSqlMap.insertAdver", adverVO);
		adverVO.setId(id);
		getSqlMapClientTemplate().insert("adverSqlMap.createAdverUser", adverVO);
	}

	@Override
	public void updateAdver(AdverVO adverVO) {
		getSqlMapClientTemplate().update("adverSqlMap.updateAdver", adverVO);
		getSqlMapClientTemplate().update("adverSqlMap.updateAdverUser", adverVO);
	}

}
