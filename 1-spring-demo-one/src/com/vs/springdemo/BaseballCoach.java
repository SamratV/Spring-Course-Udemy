package com.vs.springdemo;

public class BaseballCoach implements Coach {

	// Define a private field for the dependency.
	private FortuneService fs;

	// Define a constructor for dependency injection.
	public BaseballCoach(FortuneService fs) {
		this.fs = fs;
	}
	
	public BaseballCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice.";
	}

	@Override
	public String getDailyFortune() {
		return fs.getFortune();
	}
}
