package com.kkgame.adx.publisher.service;

import java.util.List;

import com.kkgame.adx.publisher.bean.AgentVO;

public interface AgentService {

	void createAgent(AgentVO agentVO) throws Exception;
	void updateAgent(AgentVO agentVO) throws Exception;
	List<AgentVO> getAgentVOList(AgentVO agentVO) throws Exception;
	void updateAgentStatus(AgentVO agentVO) throws Exception;
	AgentVO getAgentVO(AgentVO agentVO) throws Exception;
	List<AgentVO> getAllAgentIdName(AgentVO agentVO) throws Exception;
}
