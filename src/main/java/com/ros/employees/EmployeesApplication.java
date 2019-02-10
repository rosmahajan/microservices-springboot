package com.ros.employees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ros.employees.controller", "com.ros.employees.apis"})
public class EmployeesApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(EmployeesApplication.class, args);
		
		
		// Enable below code for persisting data manually by setting it into employee object
		/* ConfigurableApplicationContext ctx = SpringApplication.run(EmployeesApplication.class, args);
		
		 * EmployeeDataAccess access = ctx.getBean(EmployeeDataAccess.class);
		 * 
		 * Employee employee = new Employee(); employee.setEmployeeNumber(1003);
		 * employee.setName("Suresh"); employee.setSalary(1224);
		 * 
		 * access.registerEmployee(employee);
		 * 
		 * for(Employee e : access.getAllEmployees()) {
		 * System.out.println("Employee Details"+e);
		 * 
		 * }
		 * 
		 * 
		 * ctx.close();
		 */
	}

}

