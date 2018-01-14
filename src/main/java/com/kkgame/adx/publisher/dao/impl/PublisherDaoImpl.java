package com.kkgame.adx.publisher.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.publisher.bean.PublisherVO;
import com.kkgame.adx.publisher.dao.PublisherDao;

public class PublisherDaoImpl extends SqlMapClientDaoSupport implements PublisherDao {

	@Override
	public void createPublisher(PublisherVO publisherVO) throws Exception {
		int roleId = (int) getSqlMapClientTemplate().insert("publisherSqlMap.createPublisher", publisherVO);
		publisherVO.setId(roleId);
		getSqlMapClientTemplate().insert("publisherSqlMap.createloginUser", publisherVO);
	}

	@Override
	public void updatePublisher(PublisherVO publisherVO) throws Exception {
		getSqlMapClientTemplate().update("publisherSqlMap.updatePublisher", publisherVO);
		getSqlMapClientTemplate().update("publisherSqlMap.updateLoginUser", publisherVO);
	}

	@Override
	public List<PublisherVO> getPublisherVOList(PublisherVO publisherVO) throws Exception {
		int count = (int) getSqlMapClientTemplate().queryForObject("publisherSqlMap.getPublisherVOListCount", publisherVO);
		publisherVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("publisherSqlMap.getPublisherVOList", publisherVO);
	}

	@Override
	public void updatePublisherStatus(PublisherVO publisherVO) throws Exception {
		getSqlMapClientTemplate().update("publisherSqlMap.updatePublisherStatus", publisherVO);
	}

	@Override
	public PublisherVO getPublisherVO(PublisherVO publisherVO) throws Exception {
		return (PublisherVO) getSqlMapClientTemplate().queryForObject("publisherSqlMap.getPublisherVO", publisherVO);
	}

	
}
