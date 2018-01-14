package com.kkgame.adx.publisher.service.impl;

import java.util.List;

import com.kkgame.adx.publisher.bean.AgentVO;
import com.kkgame.adx.publisher.dao.AgentDao;
import com.kkgame.adx.publisher.service.AgentService;

public class AgentServiceImpl implements AgentService{
	
	private AgentDao agentDao;
	
	public AgentDao getAgentDao() {
		return agentDao;
	}

	public void setAgentDao(AgentDao agentDao) {
		this.agentDao = agentDao;
	}

	@Override
	public void createAgent(AgentVO agentVO) throws Exception {
		agentDao.createAgent(agentVO);
	}

	@Override
	public void updateAgent(AgentVO agentVO) throws Exception {
		agentDao.updateAgent(agentVO);
	}

	@Override
	public List<AgentVO> getAgentVOList(AgentVO agentVO) throws Exception {
		return agentDao.getAgentVOList(agentVO);
	}

	@Override
	public void updateAgentStatus(AgentVO agentVO) throws Exception {
		agentDao.updateAgentStatus(agentVO);
	}

	@Override
	public AgentVO getAgentVO(AgentVO agentVO) throws Exception {
		return agentDao.getAgentVO(agentVO);
	}

	@Override
	public List<AgentVO> getAllAgentIdName(AgentVO agentVO) throws Exception {
		return agentDao.getAllAgentIdName(agentVO);
	}

}
