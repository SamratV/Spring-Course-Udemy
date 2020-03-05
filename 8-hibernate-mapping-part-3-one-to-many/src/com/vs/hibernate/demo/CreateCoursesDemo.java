package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Course;
import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Get the instructor form DB.
			System.out.println("Retrieving instructor by id...");
			int id = 1;
			Instructor in = session.get(Instructor.class, id);
			System.out.println("Retrieved instructor: " + in);
			
			// Create some courses.
			System.out.println("Creating new courses...");
			Course c1 = new Course("PHP");
			Course c2 = new Course("GOLANG");
			
			// Add courses to instructor.
			System.out.println("Adding the courses...");
			in.add(c1);
			in.add(c2);
			
			// Save the courses.
			System.out.println("Saving the courses...");
			session.save(c1);
			session.save(c2);
			
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
