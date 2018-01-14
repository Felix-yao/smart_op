package com.kkgame.adx.publisher.action;

import java.util.ArrayList;
import java.util.List;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.publisher.bean.AppVO;
import com.kkgame.adx.publisher.bean.PublisherVO;
import com.kkgame.adx.publisher.service.AppService;

import net.sf.json.JSONObject;

public class AppAction extends BaseAction{
	
	private AppService appService;
	private AppVO appVO;
	private int id;
	private String name;
	private int status;
	
	public String appCreatePage(){
		return "appCreatePage";
	}
	
	public String appListPage(){
		return "appListPage";
	}
	
	public String appUpdatePage(){
		if(appVO == null){
			appVO = new AppVO();
		}
		try {
			appVO = appService.getAppVO(appVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "appUpdatePage";
	}
	
	public void appList(){
		if(appVO == null){
			appVO = new AppVO();
		}
		appVO.setPageVO(getPage());
		appVO.setId(getId());
		appVO.setName(getName());
		appVO.setStatus(getStatus());
		
		JSONObject data = new JSONObject();
		List<AppVO> appList = new ArrayList<>();
		try {
			
			LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
	        if("PY".equals(user.getRoleType())){
	        	appVO.setAgentId(user.getRoleId());
			} else if("AMP".equals(user.getRoleType())){
				appVO.setAmId(user.getRoleId());
			} else if("PB".equals(user.getRoleType())){
				appVO.setPublisherId(user.getRoleId());
			}
	        
			appList = appService.getAppVOList(appVO);
			
			data.put("data", appList);
			data.put("draw", appVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",appVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", appVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
			data.put("data", appList);
			data.put("draw", appVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",appVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", appVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		}
	}
	
	public String appSave(){
		if(appVO == null){
			appVO = new AppVO();
		}
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
        if("PY".equals(user.getRoleType()) || "AMP".equals(user.getRoleType())){
        	appVO.setClickPercent(100);
        	appVO.setShowPercent(100);
        	appVO.setPricePercent(80);
        	appVO.setDspOpType(0);
        	appVO.setDsps("");
		} else if("PB".equals(user.getRoleType())){
			appVO.setClickPercent(100);
        	appVO.setShowPercent(100);
        	appVO.setPricePercent(80);
        	appVO.setDspOpType(0);
        	appVO.setDsps("");
        	appVO.setPublisherId(user.getRoleId());
		}
		
		try {
			int id = appService.createApp(appVO);
			appVO.setId(id);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void updateSave(){
		if(appVO == null){
			appVO = new AppVO();
		}
		
		try {
			appService.updateApp(appVO);
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	public void appUpdateStatus(){
		if(appVO == null){
			appVO = new AppVO();
		}
		
		try {
			appService.updateAppStatus(appVO);
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	//get set
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public AppService getAppService() {
		return appService;
	}
	public void setAppService(AppService appService) {
		this.appService = appService;
	}
	public AppVO getAppVO() {
		return appVO;
	}
	public void setAppVO(AppVO appVO) {
		this.appVO = appVO;
	}
}
