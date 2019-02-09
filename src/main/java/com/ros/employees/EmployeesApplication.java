package com.ros.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ros.employees.apis.EmployeeDataAccess;
import com.ros.employees.entities.Employee;

@SpringBootApplication
public class EmployeesApplication {

	public static void main(String[] args) {
		
//		SpringApplication.run(EmployeesApplication.class, args);
		
		ConfigurableApplicationContext ctx = SpringApplication.run(EmployeesApplication.class, args);
		EmployeeDataAccess access = ctx.getBean(EmployeeDataAccess.class);
		
		Employee employee = new Employee();
		employee.setEmployeeNumber(1003);
		employee.setName("Suresh");
		employee.setSalary(1224);
		
		access.registerEmployee(employee);
		
		for(Employee e : access.getAllEmployee()) {
			System.out.println("Employee Details"+e);
			
		}
		
		
		ctx.close();
	}

}

