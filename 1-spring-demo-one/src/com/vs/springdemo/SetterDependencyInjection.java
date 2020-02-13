package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * # CODE 4: Inversion of Control with Setter Dependency Injection (XML based).
 */

public class SetterDependencyInjection {

	public static void main(String[] args) {
		// Load the spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container.
		CricketCoach coach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// Call methods on the bean.
		System.out.println();
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		// Close the context.
		context.close();
	}

}
