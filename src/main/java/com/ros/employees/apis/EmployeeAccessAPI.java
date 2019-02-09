package com.ros.employees.apis;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ros.employees.entities.Employee;

@Component
@Path("/api/employees/")
public class EmployeeAccessAPI {

	EmployeeDataAccess employeeDataAccess;

	public EmployeeDataAccess getEmployeeDataAccess() {
		return employeeDataAccess;
	}

	@Autowired
	public void setEmployeeDataAccess(EmployeeDataAccess employeeDataAccess) {
		this.employeeDataAccess = employeeDataAccess;
	}

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee addEmployee(@BeanParam Employee emp) {
		return getEmployeeDataAccess().registerEmployee(emp);
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee updateEmployee(Employee emp) {
		return getEmployeeDataAccess().registerEmployee(emp);
	}
	
	@GET
	@Path("/list")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Iterable<Employee> fetchAllEmployees() {
		return getEmployeeDataAccess().getAllEmployees();
	}
	
	@GET
	@Path("/find/{employeeNumber}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee getByEmployeeNumber(@PathParam("employeeNumber") int empNumber) {
		return getEmployeeDataAccess().findByEmployeeNumber(empNumber);
	}
	
	@DELETE
	@Path("/delete/{employeeNumber}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Employee deleteEmployee(@PathParam("employeeNumber") int empNumber) {
		return getEmployeeDataAccess().removeEmployee(empNumber);
	}
}
