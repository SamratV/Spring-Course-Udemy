package com.vs.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.vs.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	// Define @PostConstruct to load the student data - only once!!
	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Vaibhaw", "Samrat"));
		students.add(new Student("Anubhaw", "Samrat"));
		students.add(new Student("Sambhaw", "Samrat"));
	}

	// Define endpoint "/students" - returns list of students.
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	// Define endpoint for "/students/{studentId}" - return student at an index.
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if (studentId < 0 || studentId >= students.size()) {
			throw new StudentNotFoundException("Student id not found: " + studentId);
		}

		return students.get(studentId);
	}

	/*
	 * The below method of EXCEPTION HANDLING works BUT:
	 * • Exception handler code is only for this specific REST controller
	 * • Can't be reused by other controllers :-(
	 * • We need global exception handlers
	 *   • Promotes reuse
	 *   • Centralizes exception handling
	 */
	// Add an exception handler for IndexOutOfBoundsException / StudentNotFoundException.
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(e.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	// Add an exception handler for any exception.
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(
				e instanceof MethodArgumentTypeMismatchException
				? "INTEGER input expected."
				: "Bad request."
		);
		error.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
