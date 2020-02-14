package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KabbadiCoach implements Coach {

	/*
	 * Note: Default constructor runs first and then the autowired object is
	 * injected using the concept of "java reflection".
	 */

	@Autowired
	FortuneService fortuneService;

	public KabbadiCoach() {
		System.out.println(">> KabbadiCoach: Inside default constructor.");
	}

	@Override
	public String getDailyWorkout() {
		return "Practise raiding.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
