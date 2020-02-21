package com.vs.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @Controller extends @Component and is picked up during component scanning.
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
}
