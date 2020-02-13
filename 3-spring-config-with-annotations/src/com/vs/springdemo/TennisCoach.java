package com.vs.springdemo;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practise backhand volley.";
	}

	@Override
	public String getDailyFortune() {
		return null;
	}

}
