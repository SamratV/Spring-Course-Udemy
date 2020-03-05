package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Course;
import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			// Create the objects.
			Instructor in = new Instructor("Rob", "Percival", "teched_rob@luv2code.com");
			InstructorDetail ind  = new InstructorDetail("https://www.youtube.com/teched_rob", "Writing");
			
			// Associate the objects.
			in.setInstructorDetail(ind);
			
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Save the instructor.
			session.save(in);
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		} finally {
			// IMPORTANT: Add clean up code.
			session.close();
			factory.close();
		}
	}

}
