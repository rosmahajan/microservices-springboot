package com.ros.employees.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ros.employees.apis.EmployeeDataAccess;
import com.ros.employees.entities.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	
	EmployeeDataAccess employeeDataAccessDao;
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("emps", getEmployeeDataAccessDao().getAllEmployees());
		return "empList";
	}
	
	@GetMapping("/showForm")
	public String empForm(Model model) {
		Employee employee = new Employee();
		employee.setEmployeeNumber(-1);
		employee.setName("Unknown");
		employee.setSalary(0);

		model.addAttribute("empForm", employee);
		return "empForm";
	}

	@PostMapping("/register")
	public String registerEmployee(@Valid @ModelAttribute("empForm") Employee employee, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "empForm";
		}
		getEmployeeDataAccessDao().registerEmployee(employee);
		return listEmployees(model);
	}
	
	
	@GetMapping("/simple")
	public String simpleRequest(@RequestParam String name, Model m) {
		System.out.println("Welcome : "+name);
		m.addAttribute("name", name);
		return "simple";
	}
	
	public EmployeeDataAccess getEmployeeDataAccessDao() {
		return employeeDataAccessDao;
	}

	@Autowired
	public void setEmployeeDataAccessDao(EmployeeDataAccess employeeDataAccessDao) {
		this.employeeDataAccessDao = employeeDataAccessDao;
	}
	
}
