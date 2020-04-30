package com.vs.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// Read the screenshots in "Readme - IMPORTANT - Spring Data JPA Query Methods".
	public List<Employee> findAllByOrderByLastNameAsc();
	
}
