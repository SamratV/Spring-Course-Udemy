package com.vs.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
