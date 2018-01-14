package com.kkgame.adx.publisher.action;

import java.util.ArrayList;
import java.util.List;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.publisher.bean.AgentVO;
import com.kkgame.adx.publisher.service.AgentService;

import net.sf.json.JSONObject;

public class AgentAction extends BaseAction{
	
	private AgentService agentService;
	private AgentVO agentVO;
	private int id;
	private String name;
	private String email;
	private int status;
	
	public String agentListPage(){
		return "agentListPage";
	}
	
	public String agentUpdatePage(){
		
		if(agentVO == null){
			agentVO = new AgentVO();
		}
		
		try {
			agentVO = agentService.getAgentVO(agentVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "agentUpdatePage";
	}
	
	public String agentCreatePage(){
		return "agentCreatePage";
	}
	
	public void agentList(){
		agentVO = new AgentVO();
		agentVO.setId(getId());
		agentVO.setName(getName());
		agentVO.setEmail(getEmail());
		agentVO.setStatus(getStatus());
		agentVO.setPageVO(getPage());
		
		JSONObject data = new JSONObject();
		try {
			List<AgentVO> agentVOList = agentService.getAgentVOList(agentVO);
			data.put("data", agentVOList);
			data.put("draw", agentVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",agentVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", agentVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
			ArrayList<Object> agentVOList = new ArrayList<>();
			data.put("data", agentVOList);
			data.put("draw", agentVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",0);
			data.put("recordsFiltered", 0);
			printJsonMessage(data.toString());
		}
	}
	
	public void agentSave(){
		if(agentVO == null){
			agentVO = new AgentVO();
		}
		
		try {
			if(agentVO.getId()>0){
				agentService.updateAgent(agentVO);
			}else{
				agentService.createAgent(agentVO);
			}
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	public void agentUpdateStatus(){
		
		if(agentVO == null){
			agentVO = new AgentVO();
		}
		
		try {
			agentService.updateAgentStatus(agentVO);
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	//get set
	public AgentService getAgentService() {
		return agentService;
	}
	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}
	public AgentVO getAgentVO() {
		return agentVO;
	}
	public void setAgentVO(AgentVO agentVO) {
		this.agentVO = agentVO;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
