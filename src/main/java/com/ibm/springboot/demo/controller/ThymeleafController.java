package com.ibm.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.service.DepartmentService;
import com.ibm.springboot.demo.service.EmployeeService;

@Controller
public class ThymeleafController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	DepartmentService departmentService;


	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/user")
	public String user(Model model) {
		
		List<Employee> empList = employeeService.getAllEmployees();
		model.addAttribute("firstName", empList.get(1).getFirstName());
		model.addAttribute("salary", empList.get(1).getSalary());
//		model.addAttribute("eid", empList.get(1).getEmployeeId());
		return "user";
	}
	
	@GetMapping("/department")
	public String deptmt(Model model) {
		
		List<Department> deptList = departmentService.getAllDepartments();
		model.addAttribute("depName", deptList.get(1).getDepartmentName());
		model.addAttribute("depManager", deptList.get(1).getManagerId());
//		model.addAttribute("eid", empList.get(1).getEmployeeId());
		return "deptmt";
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/search")
	public String searchEmployee(@RequestParam String employeeId, Model model) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		model.addAttribute("employees", employee);
		return "index";
	}
	
	@GetMapping("/d")
	public String d() {
		return "d";
	}

	@PostMapping("/d/search")
	public String searchDepartment(@RequestParam String department, Model model) {
		Department d = departmentService.getDepartmentById(department);
		model.addAttribute("department", d);
		return "d";
	}
	

}