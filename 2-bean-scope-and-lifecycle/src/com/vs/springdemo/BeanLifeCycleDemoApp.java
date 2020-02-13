package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		// Load the spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycleContext.xml");

		// Retrieve bean from spring container.
		Coach coach = context.getBean("coach", Coach.class);
		
		System.out.println(coach.getDailyWorkout());

		// Close the context.
		context.close();
	}

}
