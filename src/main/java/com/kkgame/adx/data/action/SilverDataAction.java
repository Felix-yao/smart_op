package com.kkgame.adx.data.action;

import java.util.List;

import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.data.bean.SilverDataVO;
import com.kkgame.adx.data.service.SilverDataService;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.util.CalendarFormat;

import net.sf.json.JSONObject;

public class SilverDataAction extends BaseAction{
	
	private SilverDataVO silverDataVO;
	private SilverDataService silverDataService;
	private String startDate;
	private String endDate;
	
	
	public String silverDataPage(){
		
		silverDataVO = new SilverDataVO();
		silverDataVO.setStartDate(CalendarFormat.getCurrentYmdDate());
		silverDataVO.setEndDate(CalendarFormat.getCurrentYmdDate());
		return "silverDataPage";
	}

	public void silverData(){
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
		if (silverDataVO == null) {
			silverDataVO = new SilverDataVO();
		}
		silverDataVO.setStartDate(getStartDate());
		silverDataVO.setEndDate(getEndDate());
		silverDataVO.setPageVO(getPage());
		silverDataVO.getPageVO().setOrderIndex(getPage().getOrderIndex());
		
		if("PB".equals(user.getRoleType())){
			silverDataVO.setPublisherId(user.getRoleId());
		}else{
			silverDataVO.setPublisherId(0);
		}
		
		JSONObject data = new JSONObject();
		try {
			List<SilverDataVO> listSilverDataVO = silverDataService.getAllData(silverDataVO);
			data.put("data", listSilverDataVO);
			data.put("draw", silverDataVO.getPageVO().getDraw() + 1);
			data.put("recordsTotal", silverDataVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", silverDataVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	//get set
	public SilverDataVO getSilverDataVO() {
		return silverDataVO;
	}

	public void setSilverDataVO(SilverDataVO silverDataVO) {
		this.silverDataVO = silverDataVO;
	}

	public SilverDataService getSilverDataService() {
		return silverDataService;
	}

	public void setSilverDataService(SilverDataService silverDataService) {
		this.silverDataService = silverDataService;
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
