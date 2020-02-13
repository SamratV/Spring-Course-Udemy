package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// Load the spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScopeContext.xml");

		// Retrieve bean from spring container.
		Coach coach = context.getBean("coach", Coach.class);

		Coach alphaCoach = context.getBean("coach", Coach.class);

		// check if they are the same
		boolean result = coach == alphaCoach;

		// Print out the results
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for \"coach\": " + coach);
		System.out.println("\nMemory location for \"alphaCoach\": " + alphaCoach);

		// Close the context.
		context.close();
	}

}
