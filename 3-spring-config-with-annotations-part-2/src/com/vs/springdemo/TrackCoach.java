package com.vs.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {

	@Autowired
	@Qualifier("happyFortuneService")
	FortuneService fortuneService;

	public TrackCoach() {
		System.out.println(">> TrackCoach: Inside default constructor.");
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// Define init method.
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println(">> TrackCoach: Inside init method.");
	}
	
	// Define destroy method.
	@PreDestroy
	public void doMyCleanUpStuff() {
		System.out.println(">> TrackCoach: Inside destroy method.");
	}

}
