package com.vs.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/* 	@InitBinder
	 *	• @InitBinder annotation works as a pre-processor
	 *	• It will pre-process each web request to our controller
	 *	• Method annotated with @InitBinder is executed
	 *	• We will use this to trim Strings - remove leading and trailing white space
	 *	• If String only has white spaces … trim it to null - validation problem resolution
	 */
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult) {
		
		// sysout's are for debugging.
		System.out.println("\n");
		System.out.println("Last name: |" + customer.getLastName() + "|");
		System.out.println("\nBinding result: " + theBindingResult);
		System.out.println("\n");
		
		if (theBindingResult.hasErrors()) {
			return "customer-form";
		} else {
			// System.out.println(customer);
			return "customer-confirmation";
		}
	}
	
	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Customer c = new Customer();
		model.addAttribute("customer", c);
		return "customer-form";
	}
}
