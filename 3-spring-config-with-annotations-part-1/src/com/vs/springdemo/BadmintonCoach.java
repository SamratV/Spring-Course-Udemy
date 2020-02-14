package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach {

	FortuneService fortuneService;

	public BadmintonCoach() {
		System.out.println(">> BadmintonCoach: Inside default constructor.");
	}

	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println(">> BadmintonCoach: Inside doSomeCrazyStuff() method.");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise smashing.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
