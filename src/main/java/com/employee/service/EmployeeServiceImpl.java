package com.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
	
		this.employeeRepository = employeeRepository;
	}

	
	public List<Employee> getList() 
	{
		
		return employeeRepository.getList();
	}



	public void saveRecord(Employee employee) 
	{
	employeeRepository.saveEmployee(employee);	
	}



	public void deleteRecord(int eid) 
	{
		Employee employee = employeeRepository.getEmployee(eid);
		employeeRepository.deleteEmployee(employee);
	}

	public Employee getRecord(int eid) 
	{
		Employee employee = employeeRepository.getEmployee(eid);
		
		return employee;
	}
	
	public void updateRecord(Employee employeeUpdated) 
	{
		Employee employeeExisting = employeeRepository.getEmployee(employeeUpdated.getEmpId());
		employeeRepository.updateRecord(employeeExisting, employeeUpdated);
		
	}
	

}
