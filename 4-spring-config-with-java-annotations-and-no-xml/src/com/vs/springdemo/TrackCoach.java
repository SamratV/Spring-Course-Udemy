package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;

	public TrackCoach(FortuneService fortuneService) {
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

	public String getDetails() {
		return "\n----- DETAILS -----\nCoach's email: " + email + "\nTeam: " + team + "\n";
	}
}
