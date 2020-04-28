package com.vs.springboot.demo.devtoolsdemo.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String hello() {
		return "Hello World! Time on the server is " + LocalDateTime.now() + ".";
	}
	
	@GetMapping("/hi")
	public String hi() {
		return "Hi! there.";
	}
}
