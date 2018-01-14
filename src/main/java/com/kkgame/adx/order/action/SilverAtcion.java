package com.kkgame.adx.order.action;

import java.util.List;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.order.bean.SilverVO;
import com.kkgame.adx.order.service.SilverService;

import net.sf.json.JSONObject;

public class SilverAtcion extends BaseAction{

	private SilverVO silverVO;
	private SilverService silverService;
	private String startDate;
	private String endDate;
	
	public String listPage(){
		return "listPage";
	}
	
	public void data(){
		
		if (silverVO == null) {
			silverVO = new SilverVO();
		}
		silverVO.setStartDate(getStartDate());
		silverVO.setEndDate(getEndDate());
		silverVO.setPageVO(getPage());
		silverVO.getPageVO().setOrderIndex(getPage().getOrderIndex());
		JSONObject data = new JSONObject();
		try {
			List<SilverVO> listSilverVO = silverService.listSilveVO(silverVO);
			data.put("data", listSilverVO);
			data.put("draw", silverVO.getPageVO().getDraw() + 1);
			data.put("recordsTotal", silverVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", silverVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String logisticsNumberInfoPage(){
		try {
			silverVO = silverService.getSilverVO(silverVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "logisticsNumberInfoPage";
	}
	
	public String editLogisticsNumberPage(){
		return "editLogisticsNumberPage";
	}
	
	public void updateLogisticsNumber(){
		try {
			silverService.updateLogisticsNumber(silverVO);
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	public void updateStatus(){
		try {
			silverService.updateStatus(silverVO);
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	
	
	//get set
	public SilverVO getSilverVO() {
		return silverVO;
	}
	public void setSilverVO(SilverVO silverVO) {
		this.silverVO = silverVO;
	}
	public SilverService getSilverService() {
		return silverService;
	}
	public void setSilverService(SilverService silverService) {
		this.silverService = silverService;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
