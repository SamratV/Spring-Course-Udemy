package com.vs.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemo {

	public static void main(String[] args) {
		// Read the spring config class.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

		// Get the bean from spring container.
		Coach coach = context.getBean("tennisCoach", Coach.class);

		// Call methods on the bean.
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		// Close the context.
		context.close();
	}

}
