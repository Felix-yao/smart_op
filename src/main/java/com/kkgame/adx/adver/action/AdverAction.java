package com.kkgame.adx.adver.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kkgame.adx.adver.bean.AdverVO;
import com.kkgame.adx.adver.service.AdverService;
import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.tag.bean.CountryVO;
import com.kkgame.adx.tag.bean.Employee;
import com.kkgame.adx.tag.service.EmployeeService;
import com.kkgame.adx.tag.service.SystemService;

import net.sf.json.JSONObject;

public class AdverAction extends BaseAction{

	private static Log logger = LogFactory.getLog(AdverAction.class);
	private AdverService adverService;
	private EmployeeService employeeService;
	private List<Employee> employeeList;
	private SystemService systemService;
	private List<CountryVO> countryList;
	private AdverVO adverVO;
	private int id;
	private String email;
	private String name;
	private int amId;
	private int status;
	public String query(){
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
		try {
			if (!"AMA".equalsIgnoreCase(user.getRoleType())) {
				Employee employee = new Employee();
				employee.setRoleType("AMA");
				employeeList = employeeService.selectAll(employee);
			}
			countryList = systemService.getCountryList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "query";
	}
	
	public void pageList(){
		if (adverVO == null) {
			adverVO = new AdverVO();
		}
		adverVO.setId(this.getId());
		adverVO.setAmId(this.getAmId());
		adverVO.setEmail(this.getEmail());
		adverVO.setName(this.getName());
		adverVO.setStatus(this.getStatus());
		adverVO.setPageVO(getPage());
		adverVO.getPageVO().setOrderIndex(getPage().getOrderIndex()+1);
		JSONObject data = new JSONObject();
		try {
			List<AdverVO> adverList = adverService.selectAll(adverVO);
			data.put("data", adverList);
			data.put("draw", adverVO.getPageVO().getDraw()+1);
			data.put("recordsTotal",adverVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", adverVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	
	public void updateStatus(){
		if(adverVO == null){
			adverVO = new AdverVO();
		}
		try {
			adverService.updateAdverStatus(adverVO);
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	public String create(){
		if (adverVO == null) {
			adverVO = new AdverVO();
		}
		try {
			LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
			if (!"AMA".equalsIgnoreCase(user.getRoleType())) {
				Employee employee = new Employee();
				employee.setRoleType("AMA");
				employeeList = employeeService.selectAll(employee);
			}
			countryList = systemService.getCountryList();
		} catch (Exception e) {
			logger.debug("adveraction create:" + e);
			e.printStackTrace();
		}
		return "create";
	}
	
	public String update(){
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
		try {
			if (!"AMA".equalsIgnoreCase(user.getRoleType())) {
				Employee employee = new Employee();
				employee.setRoleType("AMA");
				employeeList = employeeService.selectAll(employee);
			}
			countryList = systemService.getCountryList();
			adverVO = adverService.selectAdverById(adverVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "udpate";
	}
	public String save(){
		try {
			if (adverVO.getId() == 0) {
				adverService.insertAdver(adverVO);
				printMessage("1");
			}else{
				adverService.updateAdver(adverVO);
				printMessage("2");
			}
		} catch (Exception e) {
			printMessage("-1");
			logger.debug("adveraction save:" + e);
			e.printStackTrace();
		}
		return null;
	}
	public AdverService getAdverService() {
		return adverService;
	}
	public void setAdverService(AdverService adverService) {
		this.adverService = adverService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	public SystemService getSystemService() {
		return systemService;
	}

	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}

	public List<CountryVO> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<CountryVO> countryList) {
		this.countryList = countryList;
	}

	public AdverVO getAdverVO() {
		return adverVO;
	}

	public void setAdverVO(AdverVO adverVO) {
		this.adverVO = adverVO;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmId() {
		return amId;
	}

	public void setAmId(int amId) {
		this.amId = amId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
