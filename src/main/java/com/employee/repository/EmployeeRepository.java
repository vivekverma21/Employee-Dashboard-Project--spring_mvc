package com.employee.repository;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeRepository {

	List<Employee> getList();

	void saveEmployee(Employee employee);

	Employee getEmployee(int eid);

	void deleteEmployee(Employee employee);

	void updateRecord(Employee employeeExisting, Employee employeeUpdated);

	

}
