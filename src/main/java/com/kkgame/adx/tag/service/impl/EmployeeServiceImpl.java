package com.kkgame.adx.tag.service.impl;

import java.util.List;

import com.kkgame.adx.tag.bean.Employee;
import com.kkgame.adx.tag.dao.EmployeeDao;
import com.kkgame.adx.tag.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> selectAll(Employee employee) {
		return employeeDao.selectAll(employee);
	}

	@Override
	public List<Employee> selectAllAMBDOP(Employee employee) throws Exception {
		return employeeDao.selectAllAMBDOP(employee);
	}

	@Override
	public void updateEmployeeStatus(Employee employee) throws Exception {
		 employeeDao.updateEmployeeStatus(employee);
	}

	@Override
	public Employee selectEmployeeById(Employee employee) throws Exception {
		return employeeDao.selectEmployeeById(employee);
	}

	@Override
	public void insertEmployee(Employee employee) throws Exception {
		employeeDao.insertEmployee(employee);		
	}

	@Override
	public void updateEmployee(Employee employee) throws Exception {
		employeeDao.updateEmployee(employee);		
	}

}
