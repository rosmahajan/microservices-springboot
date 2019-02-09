package com.ros.employees.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ros.employees.entities.Employee;

public interface EmployeeJPADAO  extends CrudRepository<Employee, Integer>{
	
}
