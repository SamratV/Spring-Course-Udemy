package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Course;
import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			Instructor in = session.get(Instructor.class, id);
			System.out.println("VS: Retrieved instructor: " + in);
			
			// Get courses of the instructor.
			System.out.println("VS: Courses: " + in.getCourses());
			
			// Commit transaction.
			System.out.println("VS: Commiting the transaction...");
			session.getTransaction().commit();
			
			/* IMPORTANT
			 * 
			 * If ["fetch=FetchType.LAZY" and "session is closed"] and the following line is then executed:
			 * 		System.out.println("VS: Courses: " + in.getCourses());
			 * Then there will be an error because the courses are loaded lazily and require session access.
			 * 
			 * The solution to this problem is:
			 * 1) Execute "in.getCourses()" while the session is active and then it can be accessed later.
			 * 2) Use HQL's JOIN FETCH as written in the FetchJoinDemo class.
			 */
			
			System.out.println("VS: Done!!!");
		} finally {
			// IMPORTANT: Add clean up code.
			session.close();
			factory.close();
		}
	}

}
