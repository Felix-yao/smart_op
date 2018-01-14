package com.kkgame.adx.tag.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kkgame.adx.adver.bean.AdverVO;
import com.kkgame.adx.base.BaseAction;
import com.kkgame.adx.dsp.action.DspAction;
import com.kkgame.adx.publisher.bean.AgentVO;
import com.kkgame.adx.publisher.service.AgentService;
import com.kkgame.adx.tag.bean.Employee;
import com.kkgame.adx.tag.service.EmployeeService;

import net.sf.json.JSONObject;

public class EmployeeAction extends BaseAction{
	private static Log logger = LogFactory.getLog(EmployeeAction.class);
	private EmployeeService employeeService;
	private AgentService agentService;
	private Employee employee;
	private List<AgentVO> agentList;
	private int id;
	private String name;
	private int status;
	private String email;
	private String roleType;
	public String query(){
		return "query";
	}
	
	public void pageList(){
		if (employee == null) {
			employee = new Employee();
		}
		employee.setStatus(this.getStatus());
		employee.setName(this.getName());
		employee.setEmail(this.getEmail());
		employee.setRoleType(this.getRoleType());
		employee.setId(this.getId());
		employee.setPageVO(getPage());
		employee.getPageVO().setOrderIndex(getPage().getOrderIndex());
		JSONObject data = new JSONObject();
		try {
			List<Employee> list = employeeService.selectAllAMBDOP(employee);
			data.put("data", list);
			data.put("draw", employee.getPageVO().getDraw()+1);
			data.put("recordsTotal",employee.getPageVO().getTotalCount());
			data.put("recordsFiltered", employee.getPageVO().getTotalCount());
			printJsonMessage(data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateStatus(){
		if(employee == null){
			employee = new Employee();
		}
		try {
			employeeService.updateEmployeeStatus(employee);
			printMessage("1");
		} catch (Exception e) {
			e.printStackTrace();
			printMessage("-1");
		}
	}
	public String create(){
		try {
			agentList = agentService.getAllAgentIdName(new AgentVO());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "create";
	}
	public String update(){
		try {
			agentList = agentService.getAllAgentIdName(new AgentVO());
			employee = employeeService.selectEmployeeById(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "update";
	}
	public void save(){
		try {
			if (employee.getId() == 0) {
				employee.setProxyId(0);
				employeeService.insertEmployee(employee);
				printMessage("1");
			}else{
				employeeService.updateEmployee(employee);
				printMessage("2");
			}
		} catch (Exception e) {
			printMessage("-1");
			e.printStackTrace();
		}
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public AgentService getAgentService() {
		return agentService;
	}

	public void setAgentService(AgentService agentService) {
		this.agentService = agentService;
	}

	public List<AgentVO> getAgentList() {
		return agentList;
	}

	public void setAgentList(List<AgentVO> agentList) {
		this.agentList = agentList;
	}
	
	
}
