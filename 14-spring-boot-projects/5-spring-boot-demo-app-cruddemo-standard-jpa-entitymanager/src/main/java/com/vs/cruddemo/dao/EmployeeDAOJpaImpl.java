package com.vs.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vs.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// Create a query.
		Query query = entityManager.createQuery("from Employee");

		// Execute query and get result list.
		@SuppressWarnings("unchecked")
		List<Employee> list = query.getResultList();

		// Return the results.
		return list;
	}

	@Override
	public Employee findById(int id) {
		// Create a query.
		Employee employee = entityManager.find(Employee.class, id);

		// Return the results.
		return employee;
	}

	@Override
	public void save(Employee employee) {
		// Save or update employee.
		Employee dbemployee = entityManager.merge(employee);
		employee.setId(dbemployee.getId());
	}

	@Override
	public void deleteById(int id) {
		// Delete employee.
		Query query = entityManager.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}
