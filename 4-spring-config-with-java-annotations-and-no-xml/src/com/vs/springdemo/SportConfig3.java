package com.vs.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.vs.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig3 {
	
	// Define a bean for sad fortune service.
	@Bean
	public FortuneService sadFortuneService() { // Method name is the bean id.
		return new SadFortuneService();
	}
	
	// Define a bean for track coach and inject the dependency.
	@Bean
	public Coach trackCoach() { // Method name is the bean id.
		return new TrackCoach(sadFortuneService());
	}
}
