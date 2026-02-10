package com.employee.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository
{
	private Session session;
	private Transaction transaction;
	public EmployeeRepositoryImpl(SessionFactory sessionFactory)
	{
		session = sessionFactory.openSession();
		transaction = session.getTransaction();
	}

	public List<Employee> getList() 
	{
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		return query.list();
	}

	
	public void saveEmployee(Employee employee) 
	{
		transaction.begin();
		session.persist(employee);
		transaction.commit();
	}


	public Employee getEmployee(int eid) 
	{
		Employee employee = session.get(Employee.class, eid);
		return employee;
	}

	@Override
	public void deleteEmployee(Employee employee) 
	{
		transaction.begin();
		session.remove(employee);
		transaction.commit();
	}


	public void updateRecord(Employee employeeExisting, Employee employeeUpdated) 
	{
		transaction.begin();
		employeeExisting.setFirstName(employeeUpdated.getFirstName());
		employeeExisting.setLastName(employeeUpdated.getLastName());
		employeeExisting.setDepartment(employeeUpdated.getDepartment());
		employeeExisting.setSalary(employeeUpdated.getSalary());
		transaction.commit();
		
	}

}
