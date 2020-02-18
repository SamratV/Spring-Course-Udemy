package com.vs.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaPropertiesFileConfigDemo {

	public static void main(String[] args) {
		// Read the spring config class.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig3.class);

		// Get the bean from spring container.
		TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);

		// Call methods on the bean.
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getDetails());

		// Close the context.
		context.close();
	}

}
