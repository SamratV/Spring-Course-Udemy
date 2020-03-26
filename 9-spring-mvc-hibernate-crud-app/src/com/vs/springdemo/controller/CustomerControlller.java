package com.vs.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vs.springdemo.dao.CustomerDAO;
import com.vs.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerControlller {
	
	// Need to inject the customer DAO.
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping("/list")
	public String listCustomers(Model model) {
		// Get customers from the DAO.
		List<Customer> customers = customerDAO.getCustomers();
		
		// Add the customers to the model.
		model.addAttribute("customers", customers);
		
		return "list-customers";
	}
}
