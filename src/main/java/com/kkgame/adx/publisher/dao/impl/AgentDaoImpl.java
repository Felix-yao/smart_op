package com.kkgame.adx.publisher.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.publisher.bean.AgentVO;
import com.kkgame.adx.publisher.dao.AgentDao;
import com.kkgame.adx.util.MD5Code;

public class AgentDaoImpl extends SqlMapClientDaoSupport implements AgentDao{

	@Override
	public void createAgent(AgentVO agentVO) throws Exception {
		MD5Code md5 =new MD5Code();
		String key=md5.getMD5ofStr(String.valueOf(new Date()));
		agentVO.setKey(key);
		int id=(int)getSqlMapClientTemplate().insert("agentSqlMap.createAgent",agentVO);
		agentVO.setId(id);
		getSqlMapClientTemplate().insert("agentSqlMap.createloginUser",agentVO);
	}

	@Override
	public void updateAgent(AgentVO agentVO) throws Exception {
		getSqlMapClientTemplate().update("agentSqlMap.updateLoginUser",agentVO);
		getSqlMapClientTemplate().update("agentSqlMap.updateAgent",agentVO);
	}

	@Override
	public List<AgentVO> getAgentVOList(AgentVO agentVO) throws Exception {
		int count = (int) getSqlMapClientTemplate().queryForObject("agentSqlMap.getAgentVOListCount", agentVO);
		agentVO.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("agentSqlMap.getAgentVOList", agentVO);
	}

	@Override
	public void updateAgentStatus(AgentVO agentVO) throws Exception {
		getSqlMapClientTemplate().update("agentSqlMap.updateAgentStatus", agentVO);
	}

	@Override
	public AgentVO getAgentVO(AgentVO agentVO) throws Exception {
		return (AgentVO) getSqlMapClientTemplate().queryForObject("agentSqlMap.getAgentVO", agentVO);
	}

	@Override
	public List<AgentVO> getAllAgentIdName(AgentVO agentVO) throws Exception {
		return getSqlMapClientTemplate().queryForList("agentSqlMap.getAllAgentIdName", agentVO);
	}
	
	

}
