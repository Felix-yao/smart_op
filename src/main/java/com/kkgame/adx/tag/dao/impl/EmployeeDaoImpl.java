package com.kkgame.adx.tag.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.kkgame.adx.tag.bean.Employee;
import com.kkgame.adx.tag.dao.EmployeeDao;

public class EmployeeDaoImpl extends SqlMapClientDaoSupport implements EmployeeDao {

	@Override
	public List<Employee> selectAll(Employee employee) {
		return getSqlMapClientTemplate().queryForList("employeeSqlMap.selectAll", employee);
	}

	@Override
	public List<Employee> selectAllAMBDOP(Employee employee) {
		int count = (int) getSqlMapClientTemplate().queryForObject("employeeSqlMap.selectAllAMBDOPCount", employee);
		employee.getPageVO().setTotalCount(count);
		return getSqlMapClientTemplate().queryForList("employeeSqlMap.selectAllAMBDOP", employee);
	}

	@Override
	public void updateEmployeeStatus(Employee employee) {
		getSqlMapClientTemplate().update("employeeSqlMap.updateEmployeeStatus",employee);
	}

	@Override
	public Employee selectEmployeeById(Employee employee) {
		return (Employee) getSqlMapClientTemplate().queryForObject("employeeSqlMap.selectEmployeeById", employee);
	}

	@Override
	public void insertEmployee(Employee employee) {
		int id = (int) getSqlMapClientTemplate().insert("employeeSqlMap.insertEmployee", employee);
		employee.setId(id);
		getSqlMapClientTemplate().insert("employeeSqlMap.insertEmployeeUser", employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		getSqlMapClientTemplate().update("employeeSqlMap.updateEmployee",employee);
		getSqlMapClientTemplate().update("employeeSqlMap.updateEmployeeUser",employee);
	}

}
