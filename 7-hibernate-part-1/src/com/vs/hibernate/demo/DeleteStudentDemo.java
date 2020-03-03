package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// Deleting a student data.
			System.out.println("Deleting a student data(Method 1)...");
			session.delete(st);
			
			// Commit the transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			System.out.println();
			
			// NEW CODE
			
			// Start a transaction.
			session = factory.getCurrentSession();
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Deleting a student data.
			System.out.println("Deleting a student data(Method 2)...");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			// Commit the transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} finally {
			factory.close();
		}
	}

}
