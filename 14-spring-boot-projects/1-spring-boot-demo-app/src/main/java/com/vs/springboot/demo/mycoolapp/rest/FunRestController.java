package com.vs.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String hello() {
		return "Hello World! Time on the server is " + LocalDateTime.now() + ".";
	}
}
