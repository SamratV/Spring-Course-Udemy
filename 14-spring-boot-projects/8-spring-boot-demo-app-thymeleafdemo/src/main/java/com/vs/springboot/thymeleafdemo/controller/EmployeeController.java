package com.vs.springboot.thymeleafdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vs.springboot.thymeleafdemo.entity.Employee;
import com.vs.springboot.thymeleafdemo.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired // Since we have only one constructor, @Autowired is optional.
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public String getEmployees(Model model) {
		List<Employee> list = employeeService.findAll();
		model.addAttribute("employees", list);
		return "employees/list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		// Save the employee.
		employeeService.save(employee);
		
		// Use a redirect to prevent duplicate submissions.
		return "redirect:/employees/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("employee", employee);
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int id) {
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
	
}
