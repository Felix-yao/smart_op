package com.kkgame.adx.publisher.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.publisher.bean.ADPositionVO;
import com.kkgame.adx.publisher.dao.ADPositionDao;

public class ADPositionDaoImpl extends SqlMapClientDaoSupport implements ADPositionDao{

	@Override
	public void createADPosition(ADPositionVO adPositionVO) throws Exception {
		getSqlMapClientTemplate().insert("adPositionSqlMap.createADPosition", adPositionVO);
	}

	@Override
	public void updateADPosition(ADPositionVO adPositionVO) throws Exception {
		getSqlMapClientTemplate().update("adPositionSqlMap.updateADPosition", adPositionVO);
	}

	@Override
	public List<ADPositionVO> getADPositionList(ADPositionVO adPositionVO) throws Exception {
		int count = (int) getSqlMapClientTemplate().queryForObject("adPositionSqlMap.getADPositionListCount", adPositionVO);
		adPositionVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("adPositionSqlMap.getADPositionList", adPositionVO);
	}

	@Override
	public ADPositionVO getADPosition(ADPositionVO adPositionVO) throws Exception {
		return (ADPositionVO) getSqlMapClientTemplate().queryForObject("adPositionSqlMap.getADPosition", adPositionVO);
	}

	@Override
	public void updateADPositionStatus(ADPositionVO adPositionVO) throws Exception {
		getSqlMapClientTemplate().update("adPositionSqlMap.updateADPositionStatus", adPositionVO);
	}

}
