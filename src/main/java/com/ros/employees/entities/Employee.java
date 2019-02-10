package com.ros.employees.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name="JPA_BOOT_Employees")
public class Employee {
	
	@FormParam("employeeNumber")
	int employeeNumber;
	
	@FormParam("name")
	String name;
	
	@FormParam("salary")
	double salary;
	
	@Id
	@Min(value=999, message="Number should be greater than {value}")
	@Max(value=99999999, message="Number should be less than {value}")
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	
	@Size(min=5,max=15,message="Name must be betwwen {min} and {max}")
	@Pattern(regexp="[A-Za-z0-9]+", message="Name must be in the text format")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@DecimalMin(value="1000.0", message="Salary should be greater than {value}")
	@DecimalMax(value="10000000.0", message="Salary should be less than {value}")
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeNumber=" + employeeNumber + ", name=" + name + ", salary=" + salary + "]";
	}
}
