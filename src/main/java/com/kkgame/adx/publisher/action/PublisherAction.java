package com.kkgame.adx.publisher.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.publisher.bean.PublisherVO;
import com.kkgame.adx.publisher.service.PublisherService;

import net.sf.json.JSONObject;

public class PublisherAction extends BaseAction{
	
	private PublisherVO publisherVO;
	
	private PublisherService publisherService;
	
	private String name;
	private int id;
	private int amId;
	private int status;
	private String email;
	
	public String publisherListPage(){
		return "publisherListPage";
	}
	
	public String publisherCreatePage(){
		return "publisherCreatePage";
	}
	
	public String publisherUpdatePage(){
		if(publisherVO == null){
			publisherVO = new PublisherVO();
		}
		
		try {
			publisherVO = publisherService.getPublisherVO(publisherVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "publisherUpdatePage";
	}
	
	//New getPublisherList
	public void publisherList(){
        LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
        if(publisherVO == null){
        	publisherVO = new PublisherVO();
        }
        if("AMP".equals(user.getRoleType())){
        	publisherVO.setAmId(user.getRoleId());
		}else if("PY".equals(user.getRoleType())){
        	publisherVO.setAgentId(user.getRoleId());
        }
        publisherVO.setPageVO(getPage());
        publisherVO.setEmail(getEmail());
        publisherVO.setName(getName());
        publisherVO.setStatus(getStatus());
        publisherVO.setId(getId());
        try {
			List<PublisherVO> publisherList = publisherService.getPublisherVOList(publisherVO);
			JSONObject data = new JSONObject();
			data.put("data", publisherList);
			data.put("draw", publisherVO.getPageVO().getDraw()+1);
			data.put("recordsTotal", publisherVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", publisherVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//new updateStatus
	public void publisherUpdateStatus(){
		if(publisherVO == null){
			publisherVO = new PublisherVO();
		}
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
        if("AMP".equals(user.getRoleType())){
        	publisherVO.setAmId(user.getRoleId());
		}
		try {
			publisherService.updatePublisherStatus(publisherVO);
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	public void publisherSave(){
		if(publisherVO == null){
			publisherVO = new PublisherVO();
		}
		
		try {
			if(publisherVO.getId()>0){
				publisherService.updatePublisher(publisherVO);
			}else{
				publisherService.createPublisher(publisherVO);
			}
			
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	
	public PublisherService getPublisherService() {
		return publisherService;
	}
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAmId() {
		return amId;
	}
	public void setAmId(int amId) {
		this.amId = amId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PublisherVO getPublisherVO() {
		return publisherVO;
	}
	public void setPublisherVO(PublisherVO publisherVO) {
		this.publisherVO = publisherVO;
	}
}
