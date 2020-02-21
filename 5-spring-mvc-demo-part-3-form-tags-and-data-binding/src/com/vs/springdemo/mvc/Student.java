package com.vs.springdemo.mvc;

public class Student {
	
	private String firstName;
	private String lastName;
	
	public Student() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "\n\nStudent Name: " + firstName + " " + lastName + "\n\n";
	}

}
