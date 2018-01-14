package com.kkgame.adx.publisher.dao;

import java.util.List;

import com.kkgame.adx.publisher.bean.AgentVO;

public interface AgentDao {
	
	void createAgent(AgentVO agentVO) throws Exception;
	void updateAgent(AgentVO agentVO) throws Exception;
	List<AgentVO> getAgentVOList(AgentVO agentVO) throws Exception;
	void updateAgentStatus(AgentVO agentVO) throws Exception;
	AgentVO getAgentVO(AgentVO agentVO) throws Exception;
	List<AgentVO> getAllAgentIdName(AgentVO agentVO) throws Exception;
	
}
