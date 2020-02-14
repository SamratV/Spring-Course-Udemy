package com.vs.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
	
	@Autowired
	@Qualifier("happyFortuneService")
	FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	    
	@Value("${foo.team}")
	private String team;
	
	public SwimCoach() {
		System.out.println(">> SwimCoach: Inside the default constructor.");
	}

	@Override
	public String getDailyWorkout() {
		return "Practise swimming for 20 minutes.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public String getDetails() {
		return "Coach's email: " + email + "\nTeam: " + team + "\n";
	}

}
