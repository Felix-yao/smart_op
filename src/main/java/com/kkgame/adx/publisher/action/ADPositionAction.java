package com.kkgame.adx.publisher.action;

import java.util.ArrayList;
import java.util.List;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.publisher.bean.ADPositionVO;
import com.kkgame.adx.publisher.service.ADPositionService;
import net.sf.json.JSONObject;

public class ADPositionAction extends BaseAction{
	
	private ADPositionService adPositionService;
	private ADPositionVO adPositionVO;
	private int id;
	private int status;
	private int appId;
	private String name;
	
	public String adPositionCreatePage(){
		return "adPositionCreatePage";
	}
	
	public String adPositionListPage(){
		return "adPositionListPage";
	}
	
	public String adPositionUpdatePage(){
		if(adPositionVO == null){
			adPositionVO = new ADPositionVO();
		}
		try {
			adPositionVO = adPositionService.getADPosition(adPositionVO);
			if(adPositionVO.getWidth() == 320 && adPositionVO.getHeight() == 480){
				adPositionVO.setSize(1);
			} else if(adPositionVO.getWidth() == 320 && adPositionVO.getHeight() == 50){
				adPositionVO.setSize(2);
			} else if(adPositionVO.getWidth() == 300 && adPositionVO.getHeight() == 250){
				adPositionVO.setSize(3);
			}
//			 java.text.DecimalFormat df = new java.text.DecimalFormat("########.00000");
//			adPositionVO.setBidPriceString(df.format(adPositionVO.getBidPrice()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "adPositionUpdatePage";
	}
	
	public void adPositionList(){
		if(adPositionVO == null){
			adPositionVO = new ADPositionVO();
		}
		adPositionVO.setPageVO(getPage());
		adPositionVO.setId(getId());
		adPositionVO.setName(getName());
		adPositionVO.setStatus(getStatus());
		adPositionVO.setAppId(getAppId());
		
		JSONObject data = new JSONObject();
		List<ADPositionVO> adPositionList = new ArrayList<>();
		try {
			
			LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
	        if("PY".equals(user.getRoleType())){
	        	adPositionVO.setAgentId(user.getRoleId());
			} else if("AMP".equals(user.getRoleType())){
				adPositionVO.setAmId(user.getRoleId());
			} else if("PB".equals(user.getRoleType())){
				adPositionVO.setPublisherId(user.getRoleId());
			}
	        
			adPositionList = adPositionService.getADPositionList(adPositionVO);
			
			data.put("data", adPositionList);
			data.put("draw", adPositionVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",adPositionVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", adPositionVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
			data.put("data", adPositionList);
			data.put("draw", adPositionVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",adPositionVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", adPositionVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		}
	}
	
	public void adPositionSave(){
		if(adPositionVO == null){
			adPositionVO = new ADPositionVO();
		}
		
		if(adPositionVO.getSize() == 1){
			adPositionVO.setWidth(320);
			adPositionVO.setHeight(480);
		} else if(adPositionVO.getSize() == 2){
			adPositionVO.setWidth(320);
			adPositionVO.setHeight(50);
		} else if(adPositionVO.getSize() == 3){
			adPositionVO.setWidth(300);
			adPositionVO.setHeight(250);
		}
		
		try {
			if(adPositionVO.getId()>0){
				adPositionService.updateADPosition(adPositionVO);
			}else{
				adPositionService.createADPosition(adPositionVO);
			}
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	public void adPositionUpdateStatus(){
		if(adPositionVO == null){
			adPositionVO = new ADPositionVO();
		}

		try {
			adPositionService.updateADPositionStatus(adPositionVO);
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
	public ADPositionService getAdPositionService() {
		return adPositionService;
	}
	public void setAdPositionService(ADPositionService adPositionService) {
		this.adPositionService = adPositionService;
	}
	public ADPositionVO getAdPositionVO() {
		return adPositionVO;
	}
	public void setAdPositionVO(ADPositionVO adPositionVO) {
		this.adPositionVO = adPositionVO;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	
}
