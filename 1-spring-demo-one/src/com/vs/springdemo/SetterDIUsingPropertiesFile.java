package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * # CODE 6: Inversion of Control with Setter Literal Value Dependency Injection from properties file (XML based).
 */

public class SetterDIUsingPropertiesFile {

	public static void main(String[] args) {
		// Load the spring configuration file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container.
		CricketCoach coach = context.getBean("myNewCricketCoach", CricketCoach.class);
		
		// Call methods on the bean.
		System.out.println();
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println();
		System.out.println("Team: " + coach.getTeam());
		System.out.println("Email address: " + coach.getEmailAddress());
		
		// Close the context.
		context.close();
	}

}
