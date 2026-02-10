package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService 
{

	List<Employee> getList();

	void saveRecord(Employee employee);

	void deleteRecord(int eid);

	Employee getRecord(int eid);

	void updateRecord(Employee employee);

	
	

}
