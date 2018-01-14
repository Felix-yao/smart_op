package com.kkgame.adx.data.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.data.bean.SilverDataVO;
import com.kkgame.adx.data.dao.SilverDataDao;

public class SilverDataDaoImpl extends SqlMapClientDaoSupport implements SilverDataDao {

	@Override
	public List<SilverDataVO> getPublisherData(SilverDataVO silverDataVO) throws Exception {
		
		return getSqlMapClientTemplate().queryForList("silverDataSqlMap.allOrderCount", silverDataVO);
	}

	@Override
	public List<SilverDataVO> getAllData(SilverDataVO silverDataVO) throws Exception {
		
		int count = (int) getSqlMapClientTemplate().queryForObject("silverDataSqlMap.getAllDataCount", silverDataVO);
		silverDataVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("silverDataSqlMap.getAllData", silverDataVO);
	}

}
