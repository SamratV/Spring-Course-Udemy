package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			// Get instructor by primary key / id.
			System.out.println("Retrieving instructor by id...");
			int id = 1;
			Instructor in = session.get(Instructor.class, id);
			System.out.println("Retrieved instructor: " + in);
			System.out.println();
			
			// Delete the instructors.
			if(in  != null) {
				System.out.println("Deleting the instructor...");
				session.delete(in);
			}
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} finally {
			factory.close();
		}
	}

}
