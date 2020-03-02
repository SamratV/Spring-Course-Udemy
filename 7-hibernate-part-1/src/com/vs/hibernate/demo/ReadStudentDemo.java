package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student st = new Student("Bret", "Lee", "bret_lee@vs.com");
			
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Save the student object.
			System.out.println("Saving the student object...");
			System.out.println(st);
			session.save(st);
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			System.out.println();
			
			// MY NEW CODE.
			
			// Find out the student's id: primary key.
			System.out.println("Saved student's generated id: " + st.getId());
			
			// Now get a new session and start the transaction.
			System.out.println("Starting the transaction...");
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the id: primary key.
			System.out.println("Retrieving student object with id: " + st.getId());
			Student _st = session.get(Student.class, st.getId());
			System.out.println("Retrieved student object: " + _st);
			
			// Commit the transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} finally {
			factory.close();
		}
	}

}
