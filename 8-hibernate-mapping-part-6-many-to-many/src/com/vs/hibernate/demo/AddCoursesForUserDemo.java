package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Course;
import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;
import com.vs.hibernate.demo.entity.Review;
import com.vs.hibernate.demo.entity.Student;

public class AddCoursesForUserDemo {

	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Get the student "John Doe" from database.
			int id = 1;
			Student s1 = session.get(Student.class, id);
			System.out.println("\nLoaded student: " + s1);
			System.out.println("Courses: " + s1.getCourses());
			
			// Create more courses.
			Course c1 = new Course("Rubik's Cube - How to Speed Cube");
			Course c2 = new Course("Atari 2600 - Game Development");
			
			// Add "John Doe" to those.
			c1.addStudent(s1);
			c2.addStudent(s1);
			
			// Save the courses.
			System.out.println("\nSaving the courses...");
			session.save(c1);
			session.save(c2);
			
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} finally {
			// IMPORTANT: Add clean up code.
			session.close();
			factory.close();
		}
	}

}
