package com.vs.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vs.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory.
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// Get the current Hibernate Session.
		Session session = sessionFactory.getCurrentSession();

		// Create a query.
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		// Execute query and get result list.
		List<Customer> customers = query.getResultList();

		// Return the results.
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		// Get the current Hibernate Session.
		Session session = sessionFactory.getCurrentSession();

		// Save the customer.
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		// Get the current Hibernate Session.
		Session session = sessionFactory.getCurrentSession();

		// Get the customer.
		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		// Get the current Hibernate Session.
		Session session = sessionFactory.getCurrentSession();

		// Delete the customer.
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Customer where id=:cid");
		query.setParameter("cid", id);
		query.executeUpdate();
	}

}
