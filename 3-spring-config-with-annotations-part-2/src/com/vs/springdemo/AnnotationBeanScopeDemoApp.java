package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// Read the spring config file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Get the beans from spring container.
		Coach coach = context.getBean("cricketCoach", Coach.class);
		Coach __coach__ = context.getBean("cricketCoach", Coach.class);

		// Check if the beans are the same.
		System.out.println();
		boolean result = coach == __coach__;
		System.out.println("Pointing to the same memory location: " + result);

		// Close the context.
		context.close();
	}

}
