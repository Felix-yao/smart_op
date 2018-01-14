package com.kkgame.adx.tag.dao;

import java.util.List;

import com.kkgame.adx.tag.bean.Employee;

public interface EmployeeDao {

	List<Employee> selectAll(Employee employee);

	List<Employee> selectAllAMBDOP(Employee employee);

	void updateEmployeeStatus(Employee employee);

	Employee selectEmployeeById(Employee employee);

	void insertEmployee(Employee employee);

	void updateEmployee(Employee employee);

}
