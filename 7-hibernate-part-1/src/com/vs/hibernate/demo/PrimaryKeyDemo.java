package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			// Create 3 student objects.
			System.out.println("Creating 3 student objects...");
			Student st1 = new Student("Paul", "Walker", "paul_walker@vs.com");
			Student st2 = new Student("Adam", "Walker", "adam_walker@vs.com");
			Student st3 = new Student("John", "Walker", "john_walker@vs.com");
			
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Save the student object.
			System.out.println("Saving the student object...");
			session.save(st1);
			session.save(st2);
			session.save(st3);
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			factory.close();
		}
	}

}
