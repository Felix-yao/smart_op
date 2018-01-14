package com.kkgame.adx.order.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.order.bean.SilverVO;
import com.kkgame.adx.order.dao.SilverDao;

public class SilverDaoImpl extends SqlMapClientDaoSupport implements SilverDao{

	@Override
	public List<SilverVO> listSilveVO(SilverVO silverVO) throws Exception {
		int count = (int) getSqlMapClientTemplate().queryForObject("silverSqlMap.listSilveVOCount", silverVO);
		silverVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("silverSqlMap.listSilveVO", silverVO);
	}

	@Override
	public void updateLogisticsNumber(SilverVO silverVO) throws Exception {
		getSqlMapClientTemplate().update("silverSqlMap.updateLogisticsNumber", silverVO);
	}

	@Override
	public void updateStatus(SilverVO silverVO) throws Exception {
		getSqlMapClientTemplate().update("silverSqlMap.updateStatus", silverVO);
	}

	@Override
	public SilverVO getSilverVO(SilverVO silverVO) throws Exception {
		return (SilverVO) getSqlMapClientTemplate().queryForObject("silverSqlMap.getSilverVO", silverVO);
	}

}
