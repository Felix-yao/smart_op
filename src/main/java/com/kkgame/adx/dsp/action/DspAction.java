package com.kkgame.adx.dsp.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.base.PkigConstants;
import com.kkgame.adx.dsp.bean.DspVO;
import com.kkgame.adx.dsp.service.DspService;
import com.kkgame.adx.login.bean.LoginUser;
import com.kkgame.adx.tag.action.Option;
import com.kkgame.adx.tag.bean.CountryVO;
import com.kkgame.adx.tag.bean.Employee;
import com.kkgame.adx.tag.service.EmployeeService;
import com.kkgame.adx.tag.service.SystemService;

import net.sf.json.JSONObject;

public class DspAction extends BaseAction {

	private static Log logger = LogFactory.getLog(DspAction.class);
	private DspService dspService;
	private EmployeeService employeeService;
	private SystemService systemService;
	private List<CountryVO> countryList;
	private List<Employee> employeeList;
	private DspVO dspVO;
	private List<DspVO> dspVOList;
	private int id;
	private int employeeId;
	private String company;
	private int countryId;
	private String name;

	public String query() {
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

	public void pageList() {
		if (dspVO == null) {
			dspVO = new DspVO();
		}
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
		dspVO.setId(this.getId());
		dspVO.setEmployeeId(this.getEmployeeId());
		if ("AMA".equalsIgnoreCase(user.getRoleType())) {
			dspVO.setEmployeeId(user.getRoleId());
		}
		dspVO.setCompany(this.getCompany());
		dspVO.setName(this.getName());
		dspVO.setCountryId(this.getCountryId());
		dspVO.setPageVO(getPage());
		dspVO.getPageVO().setOrderIndex(getPage().getOrderIndex());
		JSONObject data = new JSONObject();
		try {
			countryList = systemService.getCountryList();
			dspVOList = dspService.selectAll(dspVO);
			for (int i = 0; i < dspVOList.size(); i++) {
				DspVO dsp = dspVOList.get(i);
				String countryIds = dsp.getCountryIds();
				dsp = dealCountryIds(dsp,countryIds);
				dsp = dealAdTypes(dsp);
			}
			data.put("data", dspVOList);
			data.put("draw", dspVO.getPageVO().getDraw() + 1);
			data.put("recordsTotal", dspVO.getPageVO().getTotalCount());
			data.put("recordsFiltered", dspVO.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateStatus(){
		try {
			dspService.updateDspStatus(dspVO);
			printMessage("1");
		} catch (Exception e) {
			printMessage("-1");
			e.printStackTrace();
		}
	}

	private DspVO dealAdTypes(DspVO dsp) {
		String adType = dsp.getAdType();
		String[] split = adType.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			if (StringUtils.isNotBlank(split[i])) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				if ("1".equalsIgnoreCase(split[i])) {
					sb.append("Banner");
				}
				if ("2".equalsIgnoreCase(split[i])) {
					sb.append("Video");
				}
				if ("3".equalsIgnoreCase(split[i])) {
					sb.append("Audio");
				}
				if ("4".equalsIgnoreCase(split[i])) {
					sb.append("Native");
				}
			}
		}
		dsp.setAdTypeName(sb.toString());
		return dsp;
	}

	private DspVO dealCountryIds(DspVO dsp, String countryIds) {
		if (StringUtils.isNotBlank(countryIds)) {
			String[] split = countryIds.split(",");
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < split.length; j++) {
				if (StringUtils.isNotBlank(split[j].trim())) {
					for (int k = 0; k < countryList.size(); k++) {
						if (Integer.parseInt(split[j].trim()) == countryList.get(k).getId()) {
							if (sb.length() > 0) {
								sb.append(",");
							}
							sb.append(countryList.get(k).getName());
						}
					}
				}
			}
			dsp.setCountryName(sb.toString());
		}
		return dsp;
	}

	public String create() {
		if (dspVO == null) {
			dspVO = new DspVO();
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
			logger.debug("dspaction create:" + e);
			e.printStackTrace();
		}
		return "create";
	}

	public String update() {
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
		try {
			if (!"AMA".equalsIgnoreCase(user.getRoleType())) {
				Employee employee = new Employee();
				employee.setRoleType("AMA");
				employeeList = employeeService.selectAll(employee);
			}
			countryList = systemService.getCountryList();
			dspVO = dspService.selectDspById(dspVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "udpate";
	}
	
	public void updateDspUserStatus(){
		try {
			Employee employee = new Employee();
			employee.setId(dspVO.getId());
			employee.setRoleType("DSP");
			employee.setStatus(dspVO.getUserStatus());
			employeeService.updateEmployeeStatus(employee);
			printMessage("1");
		} catch (Exception e) {
			printMessage("-1");
			e.printStackTrace();
		}
	}

	public String save() {
		if (dspVO == null) {
			dspVO = new DspVO();
		}
		LoginUser user = (LoginUser) getSession(PkigConstants.SESSION_USER);
		try {
			if ("AMA".equalsIgnoreCase(user.getRoleType())) {
				dspVO.setEmployeeId(user.getRoleId());
			}
			dspVO = getDspWidthAndHeight(dspVO);
			if (dspVO.getId() == 0) {
				dspService.insertDsp(dspVO);
				printMessage("1");
			} else {
				dspService.updateDsp(dspVO);
				printMessage("2");
			}
		} catch (Exception e) {
			printMessage("-1");
			logger.debug("dspaction save:" + e);
			e.printStackTrace();
		}
		return null;
	}

	private DspVO getDspWidthAndHeight(DspVO dspVO) {
		Option option = new Option();
		String adType = dspVO.getAdType();
		String size = dspVO.getSize();
		List<HashMap<String, String>> offerSize = option.getOfferSize();
		String[] sizeArr = size.split(",");
		List list = new ArrayList<>();
		for (String str : sizeArr) {
			Map<String, Integer> m = new HashMap<>();
			if (StringUtils.isNotBlank(str)) {
				for (int i = 0; i < offerSize.size(); i++) {
					HashMap<String, String> map = offerSize.get(i);
					if (str.equalsIgnoreCase(map.get("key"))) {
						String s = map.get("value");
						String[] split = s.split("x");
						int width = Integer.parseInt(split[0]);
						int height = Integer.parseInt(split[1]);
						m.put("type", 1);
						m.put("width", width);
						m.put("height", height);
						list.add(m);
					}
				}

			}
		}
		Map listmap = new HashMap<>();
		listmap.put("adTypes", list);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			String json = objectMapper.writeValueAsString(listmap);
			dspVO.setSeatInfo(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dspVO;
	}

	public DspVO getDspVO() {
		return dspVO;
	}

	public void setDspVO(DspVO dspVO) {
		this.dspVO = dspVO;
	}

	public List<DspVO> getDspVOList() {
		return dspVOList;
	}

	public void setDspVOList(List<DspVO> dspVOList) {
		this.dspVOList = dspVOList;
	}

	public DspService getDspService() {
		return dspService;
	}

	public void setDspService(DspService dspService) {
		this.dspService = dspService;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
