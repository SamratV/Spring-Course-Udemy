package com.vs.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vs.springdemo.entity.Customer;
import com.vs.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Need to inject the customer Service.
	@Autowired
	private CustomerService customerService;

	/*
	 * @RequestMapping("/list") --> For all HTTP methods.
	 * 
	 * @RequestMapping(path="/list", method=RequestMethod.GET) --> For only HTTP GET
	 * method.
	 * 
	 */

	@GetMapping("/list") // For only HTTP GET method. (Recent addition in Spring 4.3.)
	public String listCustomers(Model model) {
		// Get customers from the DAO.
		List<Customer> customers = customerService.getCustomers();

		// Add the customers to the model.
		model.addAttribute("customers", customers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// Save the customer using our service.
		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		// Get the customer from the service.
		Customer customer = customerService.getCustomer(id);
		
		// Set customer as a model attribute to pre-populate the form.
		model.addAttribute("customer", customer);
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		// Save the customer using our service.
		customerService.deleteCustomer(id);

		return "redirect:/customer/list";
	}
}



























