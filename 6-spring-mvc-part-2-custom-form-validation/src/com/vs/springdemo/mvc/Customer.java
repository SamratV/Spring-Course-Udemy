package com.vs.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.vs.springdemo.mvc.validation.CourseCode;

public class Customer {

	private String firstName;
	
	@NotNull(message="is required") // If (InitBinder is used & input has white spaces only) or (no input at all).
	@Size(min=1, message="is required") // No input condition.
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message="must be greater than or equal to zero")
	@Max(value=10, message="must be less than or equal to 10")
	private Integer freePasses; // 1) Declaring it as "Integer" is necessary for making it a
	                            // required field because spring does string to integer
	                            // conversion on form submission which will not be possible
	                            // if the type is "int".
	                            // 2) Strings can be entered by the user which would lead to
	                            // TypeMismatchException. For TypeMismatchException custom setups
	                            // have been made. Look in "readme.txt" note number 3, "readme3.png",
	                            // "readme4.png" and screenshots.
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
	private String postalCode;
	
	@CourseCode(value="TOPS", message="must start with TOPS") // Custom annotation, i.e, user defined annotation.
	private String courseCode;

	public Customer() {
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
	
	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "\n\nFirst name: " + firstName + "\nLast name: " + lastName + "\n\n";
	}
}
