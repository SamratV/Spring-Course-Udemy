package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * # CODE 2: Spring way of configuring objects and using them (XML based : Inversion of Control).
 * 
 * Note: The constructor injection code inside "coach" bean tag (in XML file) was not present when this class was created.
 */

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// Load the spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container.
		Coach coach = context.getBean("coach", Coach.class);
		
		// Call methods on the bean.
		System.out.println(coach.getDailyWorkout());
		
		// Close the context.
		context.close();
	}
}
