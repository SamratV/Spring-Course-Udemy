package com.vs.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController4 {

	@RequestMapping("/showFormVersionThree")
	public String showForm() {
		return "helloworld-form-4";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String toUpper(@RequestParam("studentName") String name, Model model) {
		String message = "Hi! " + name.toUpperCase() + ".";
		
		model.addAttribute("message", message);
		
		return "helloworld4";
	}
}
