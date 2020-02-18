package com.vs.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan("com.vs.springdemo") --> Not needed since we are defining the bean manually.
public class SportConfig2 {
	
	// Define a bean for sad fortune service.
	@Bean
	public FortuneService sadFortuneService() { // Method name is the bean id.
		return new SadFortuneService();
	}
	
	// Define a bean for swim coach and inject the dependency.
	@Bean
	public Coach swimCoach() { // Method name is the bean id.
		return new SwimCoach(sadFortuneService());
	}
}
