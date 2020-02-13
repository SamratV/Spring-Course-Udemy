package com.vs.springdemo;

public class TrackCoach implements Coach {

	// Define a private field for the dependency.
	private FortuneService fs;
	
	// Define a constructor for dependency injection.
	public TrackCoach(FortuneService fs) {
		this.fs = fs;
	}
	
	public TrackCoach() {
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5km.";
	}

	@Override
	public String getDailyFortune() {
		return fs.getFortune();
	}
	
	// Add an init method.
	public void doMyStartupStuffs() {
		System.out.println("TrackCoach: Inside method doMyStartupStuffs() --> init method.");
	}
	
	// Add an destroy method.
	public void doMyCleanUpStuffs() {
		System.out.println("TrackCoach: Inside method doMyCleanUpStuffs() --> destroy method.");
	}
}
