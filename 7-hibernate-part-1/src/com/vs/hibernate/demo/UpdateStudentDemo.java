package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Retrieve student based on the id: primary key.
			System.out.println("Retrieving student object with id: " + studentId);
			Student st = session.get(Student.class, studentId);
			System.out.println("Retrieved student object: " + st);
			
			// Updating a student data.
			System.out.println("Updating a student data...");
			st.setFirstName("Scooby");
			
			// Commit the transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			System.out.println();
			
			// NEW CODE
			
			// Start a transaction.
			session = factory.getCurrentSession();
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Update email of all students.
			System.out.println("Updating email of all students...");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// Commit the transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} finally {
			factory.close();
		}
	}

}
