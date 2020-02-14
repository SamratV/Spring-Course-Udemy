package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationPropertiesFileDependencyInjection {

	public static void main(String[] args) {
		// Read the spring config file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContextPF.xml");

		// Get the bean from spring container.
		Coach coach = context.getBean("swimCoach", Coach.class);

		// Call methods on the bean.
		System.out.println();
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println("\n----- DETAILS -----");
		System.out.println(((SwimCoach)coach).getDetails());

		// Close the context.
		context.close();
	}
	
}
