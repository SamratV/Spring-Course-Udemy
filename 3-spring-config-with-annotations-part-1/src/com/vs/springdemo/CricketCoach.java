package com.vs.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practise 5 overs of batting.";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
