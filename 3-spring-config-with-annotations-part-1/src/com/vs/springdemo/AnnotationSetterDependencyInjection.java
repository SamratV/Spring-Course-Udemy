package com.vs.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationSetterDependencyInjection {

	public static void main(String[] args) {
		// Read the spring config file.
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// Get the bean from spring container.
		Coach coach = context.getBean("trackCoach", Coach.class);

		// Call methods on the bean.
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());

		// Close the context.
		context.close();
	}

}
