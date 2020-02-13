package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * # CODE 3: Inversion of Control with Constructor Dependency Injection (XML based).
 */

public class DependencyInjectionApp {

	public static void main(String[] args) {
		// Load the spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container.
		Coach coach = context.getBean("coach", Coach.class);
		
		// Call methods on the bean.
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune()); // New addition.
		
		// Close the context.
		context.close();
	}

}
