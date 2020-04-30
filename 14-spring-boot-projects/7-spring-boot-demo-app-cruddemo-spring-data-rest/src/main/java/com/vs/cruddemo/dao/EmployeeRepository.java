package com.vs.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vs.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
