package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Get the instructor detail object.
			System.out.println("Retrieving the InstructorDetail object...");
			int id = 1;
			InstructorDetail ind = session.get(InstructorDetail.class, id);
			
			// Print the instructor detail.
			System.out.println("Retrieved InstructorDetail object: " + ind);
			
			// Print the associated instructor.
			System.out.println("Associated instructor: " + ind.getInstructor());
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
	}

}
