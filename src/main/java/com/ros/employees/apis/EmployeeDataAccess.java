package com.ros.employees.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ros.employees.entities.Employee;
import com.ros.employees.repositories.EmployeeJPADAO;

@Component
public class EmployeeDataAccess {

	EmployeeJPADAO employeeDAO;

	public EmployeeJPADAO getEmployeeDAO() {
		return employeeDAO;
	}

	@Autowired
	public void setEmployeeDAO(EmployeeJPADAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	public Employee registerEmployee(Employee emp) {
		getEmployeeDAO().save(emp);
		return emp;
	}
	
	public Iterable<Employee> getAllEmployees() {
		return getEmployeeDAO().findAll();
	}
	
	public Employee findByEmployeeNumber(int empNumber) {
		return getEmployeeDAO().findById(empNumber).orElse(new Employee());
	}
	
	public Employee removeEmployee(int empNumber) {
		Employee emp = findByEmployeeNumber(empNumber);
		getEmployeeDAO().delete(emp);
		return emp;
	}
}
