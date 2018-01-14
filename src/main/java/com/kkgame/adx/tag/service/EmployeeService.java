package com.kkgame.adx.tag.service;

import java.util.List;

import com.kkgame.adx.tag.bean.Employee;

public interface EmployeeService {

	List<Employee> selectAll(Employee employee) throws Exception;

	List<Employee> selectAllAMBDOP(Employee employee) throws Exception;

	void updateEmployeeStatus(Employee employee) throws Exception;

	Employee selectEmployeeById(Employee employee) throws Exception;

	void insertEmployee(Employee employee) throws Exception;

	void updateEmployee(Employee employee) throws Exception;

}
