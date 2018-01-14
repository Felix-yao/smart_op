package com.kkgame.adx.tag.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSON;
import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.tag.bean.CountryVO;
import com.kkgame.adx.tag.bean.NameVO;
import com.kkgame.adx.tag.bean.Select2VO;
import com.kkgame.adx.tag.service.SystemService;

public class SystemAction extends BaseAction {

	private static Log logger = LogFactory.getLog(SystemAction.class);
	private NameVO nameVO;
	private SystemService systemService;
	private List<NameVO> amList;
	private List<CountryVO> countryList;
	private List<NameVO> iab1List;
	private String q;
	
	public String getAllAm() {
		if(nameVO == null) {
			nameVO = new NameVO();
		}
		try {
			LoginUser user = (LoginUser) this.getRequest().getSession().getAttribute(PkigConstants.SESSION_USER);
			if(user!=null&&"PY".equals(user.getRoleType())) {
				nameVO.setType(3);
				nameVO.setAmId(user.getRoleId());
			}
			amList = systemService.getAllAmList(nameVO);
		} catch(Exception e) {
			logger.debug(e);
		}
		return SUCCESS;
	}
	
	public String getAllCountry() {
		try {
			
			countryList = systemService.getCountryList();

		} catch(Exception e) {
			logger.debug(e);
		}
		return SUCCESS;
	}
	
	public String getAllIAB1() {
		try {
			iab1List = systemService.getAllIAB1List();
		} catch(Exception e) {
			logger.debug(e);
		}
		return SUCCESS;
	}
	
	public String getAllIAB2() {
		if(nameVO == null){
			nameVO = new NameVO();
		}
		try {
			iab1List = systemService.getIAB2List(nameVO);
		} catch(Exception e) {
			logger.debug(e);
		}
		return SUCCESS;
	}
	
	public void dspSelect2(){
		
		if(nameVO == null){
			nameVO = new NameVO();
		}
		nameVO.setName(getQ());
		List<Select2VO> list = null;
		try {
			list = systemService.getDspSelect2(nameVO);
			Select2VO select2VO = new Select2VO();
			select2VO.setId(0);
			select2VO.setText("-- Dsp --");
			list.add(0,select2VO);
			printJsonMessage(JSON.toJSONString(list));
		} catch (Exception e) {
			logger.debug(e);
		}
	}
	
	public void publisherSelect2() {
		
		try {
			if(nameVO == null) {
				nameVO = new NameVO();
			}
			nameVO.setName(getQ());
			LoginUser user = (LoginUser) this.getRequest().getSession().getAttribute(PkigConstants.SESSION_USER);
			if(user!=null&&PkigConstants.ROLE_AM_PUBLISHER.equals(user.getRoleType())) {
				nameVO.setAmId(user.getRoleId());
			}
			if(user!=null&&PkigConstants.ROLE_PROXY.equals(user.getRoleType())) {
				nameVO.setIsProxy(1);
				nameVO.setProxyId(user.getRoleId());
			}
			List<Select2VO> list = null;
			list = systemService.getPublisherSelect2(nameVO);
			Select2VO select2VO = new Select2VO();
			select2VO.setId(0);
			select2VO.setText("---Publisher---");
			list.add(0,select2VO);
			
			printMessage(JSON.toJSONString(list).toString());
		} catch(Exception e) {
			logger.debug(e);
		}
	}
	
	public void appSelect2() {
		
		if(nameVO==null) {
			nameVO = new NameVO();
		}
		nameVO.setName(getQ());
		try {
			if(nameVO == null) {
				nameVO = new NameVO();
			}
			LoginUser user = (LoginUser) this.getRequest().getSession().getAttribute(PkigConstants.SESSION_USER);
			if(user!=null&&PkigConstants.ROLE_PUBLISHER.equals(user.getRoleType())) {
				nameVO.setPublisherId(user.getRoleId());
			}
			if(user!=null&&PkigConstants.ROLE_AM_PUBLISHER.equals(user.getRoleType())) {
				nameVO.setAmId(user.getRoleId());
			}
			if(user!=null&&PkigConstants.ROLE_PROXY.equals(user.getRoleType())) {
				nameVO.setProxyId(user.getRoleId());
			}
			List<Select2VO> list = null;
			list = systemService.getAppSelect2(nameVO);
			Select2VO select2VO = new Select2VO();
			select2VO.setId(0);
			select2VO.setText("---App---");
			list.add(0,select2VO);
			printMessage(JSON.toJSONString(list).toString());
		} catch(Exception e) {
			logger.debug(e);
		}
	}
	
	public void countrySelect2() {
		
		try {
			if(nameVO == null) {
				nameVO = new NameVO();
			}
			nameVO.setName(getQ());
			List<Select2VO> list = null;
			list = systemService.getCountrySelect2(nameVO);
			Select2VO select2VO = new Select2VO();
			select2VO.setId(0);
			select2VO.setText("---Country---");
			list.add(0,select2VO);
			
			printMessage(JSON.toJSONString(list).toString());
		} catch(Exception e) {
			logger.debug(e);
		}
	}
	
	public void adPositionSelect2() {
		
		try {
			if(nameVO == null) {
				nameVO = new NameVO();
			}
			nameVO.setName(getQ());
			List<Select2VO> list = null;
			list = systemService.getADPositionSelect2(nameVO);
			Select2VO select2VO = new Select2VO();
			select2VO.setId(0);
			select2VO.setText("---ADPosition---");
			list.add(0,select2VO);
			
			printMessage(JSON.toJSONString(list).toString());
		} catch(Exception e) {
			logger.debug(e);
		}
	}
	
	//get  set
	public NameVO getNameVO() {
		return nameVO;
	}
	public void setNameVO(NameVO nameVO) {
		this.nameVO = nameVO;
	}
	public SystemService getSystemService() {
		return systemService;
	}
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	public List<NameVO> getAmList() {
		return amList;
	}
	public void setAmList(List<NameVO> amList) {
		this.amList = amList;
	}
	public List<CountryVO> getCountryList() {
		return countryList;
	}
	public void setCountryList(List<CountryVO> countryList) {
		this.countryList = countryList;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	public List<NameVO> getIab1List() {
		return iab1List;
	}
	public void setIab1List(List<NameVO> iab1List) {
		this.iab1List = iab1List;
	}
	
	
}
