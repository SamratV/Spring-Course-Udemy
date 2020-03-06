package com.vs.hibernate.demo;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Course;
import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			System.out.println("VS: Starting the transaction...");
			session.beginTransaction();
			
			// Get the instructor form DB.
			System.out.println("VS: Retrieving instructor by id...");
			int id = 1;
			
			Query<Instructor> query = session.createQuery(
			"select i from Instructor i JOIN FETCH i.courses"
			+ " where i.id=:theInstructorId"
			, Instructor.class);
			
			// Set parameter on query.
			query.setParameter("theInstructorId", id);
			
			// Execute query and get instructor.
			Instructor in = query.getSingleResult();
			
			System.out.println("VS: Retrieved instructor: " + in);
			
			// Commit transaction.
			System.out.println("VS: Commiting the transaction...");
			session.getTransaction().commit();
			
			session.close();
			System.out.println("\nSESSION CLOSED.\n");
			
			// Get courses of the instructor.
			System.out.println("VS: Courses: " + in.getCourses());
			
			System.out.println("VS: Done!!!");
		} finally {
			// IMPORTANT: Add clean up code.
			session.close();
			factory.close();
		}
	}

}
