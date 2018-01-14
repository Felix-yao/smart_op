package com.kkgame.adx.tag.dao.impl;


import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.tag.bean.CountryVO;
import com.kkgame.adx.tag.bean.NameVO;
import com.kkgame.adx.tag.bean.Select2VO;
import com.kkgame.adx.tag.dao.SystemDao;

public class SystemDaoImpl extends SqlMapClientDaoSupport implements SystemDao {

	@Override
	public List<NameVO> getAllAmList(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getAllAmList", nameVO);
	}

	@Override
	public List<CountryVO> getCountryList() throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getCountryList");
	}

	@Override
	public List<Select2VO> getDspSelect2(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getDspSelect2", nameVO);
	}

	@Override
	public List<Select2VO> getPublisherSelect2(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getPublisherSelect2", nameVO);
	}

	@Override
	public List<NameVO> getAllIAB1List() throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getAllIAB1List");
	}

	@Override
	public List<NameVO> getIAB2List(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getIAB2List",nameVO);
	}

	@Override
	public List<Select2VO> getAppSelect2(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getAppSelect2",nameVO);
	}

	@Override
	public List<Select2VO> getADPositionSelect2(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getADPositionSelect2",nameVO);
	}

	@Override
	public List<Select2VO> getCountrySelect2(NameVO nameVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("systemSqlMap.getCountrySelect2",nameVO);
	}


}
