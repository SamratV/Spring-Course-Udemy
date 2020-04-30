package com.vs.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vs.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override	
	public List<Employee> findAll() {
		
		// Get the current hibernate session.
		Session session = entityManager.unwrap(Session.class);
		
		// Create a query.
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		
		// Execute query and get result list.
		List<Employee> list = query.getResultList();
		
		// Return the results.
		return list;
	}

	@Override	
	public Employee findById(int id) {
		// Get the current hibernate session.
		Session session = entityManager.unwrap(Session.class);
		
		// Create a query.
		Employee employee = session.get(Employee.class, id);
		
		// Return the results.
		return employee;
	}

	@Override	
	public void save(Employee employee) {
		// Get the current hibernate session.
		Session session = entityManager.unwrap(Session.class);
		
		// Save or update employee.
		session.saveOrUpdate(employee);
	}

	@Override	
	public void deleteById(int id) {
		// Get the current hibernate session.
		Session session = entityManager.unwrap(Session.class);
		
		// Delete employee.
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Employee where id=:empId");
		query.setParameter("empId", id);
		query.executeUpdate();
	}

}
