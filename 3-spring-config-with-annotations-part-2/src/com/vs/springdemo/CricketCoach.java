package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Changing the default scope to "prototype".
public class CricketCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	FortuneService fortuneService;

	public CricketCoach() {
		System.out.println(">> CricketCoach: Inside the default constructor.");
	}

	@Override
	public String getDailyWorkout() {
		return "Practise wicket keeping.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
