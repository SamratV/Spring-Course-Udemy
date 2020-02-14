package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	FortuneService fortuneService;

	public TrackCoach() {
		System.out.println(">> TrackCoach: Inside default constructor.");
	}

	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println(">> TrackCoach: Inside setter method.");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
