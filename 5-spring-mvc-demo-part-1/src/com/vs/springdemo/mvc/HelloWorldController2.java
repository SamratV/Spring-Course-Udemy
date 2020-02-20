package com.vs.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController2 {
	
	@RequestMapping("/showFormVersionTwo")
	public String showForm() {
		return "helloworld-form-2";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String toUpper(HttpServletRequest request, Model model) {
		String name = request.getParameter("studentName");
		String message = "Hi! " + name.toUpperCase() + ".";
		
		model.addAttribute("message", message);
		
		return "helloworld2";
	}

}
