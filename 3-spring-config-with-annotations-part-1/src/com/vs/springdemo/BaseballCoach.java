package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

private FortuneService fortuneService;
	
	@Autowired // FortuneService has only one implementation here. Hence, we don't need @Qualifier.
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practise batting for half an hour.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
