package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	// FortuneService interface has multiple implementations, hence, we need to specify which one to use.
	@Qualifier("happyFortuneService")
	FortuneService fortuneService;

	public TennisCoach() {
		System.out.println(">> TennisCoach: Inside the default constructor.");
	}

	@Override
	public String getDailyWorkout() {
		return "Practise backhand volley.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
