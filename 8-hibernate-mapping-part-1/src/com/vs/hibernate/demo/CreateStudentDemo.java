package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			// Create a student object.
			System.out.println("Creating new student object...");
			Student st = new Student("Paul", "Walker", "paul_walker@vs.com");
			
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Save the student object.
			System.out.println("Saving the student object...");
			session.save(st);
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

}
