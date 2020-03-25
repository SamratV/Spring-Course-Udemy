package com.vs.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Course;
import com.vs.hibernate.demo.entity.Instructor;
import com.vs.hibernate.demo.entity.InstructorDetail;
import com.vs.hibernate.demo.entity.Review;
import com.vs.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			
			// Create a course.
			Course c = new Course("Piano Mastery Course");
			
			// Save the course.
			System.out.println("\nSaving the course...");
			session.save(c);
			System.out.println("Saved the course: " + c);
			
			// Create the students.
			Student s1 = new Student("John", "Doe", "JohnDoe@vs.com");
			Student s2 = new Student("John", "Cena", "JohnCena@vs.com");
			Student s3 = new Student("Chris", "Evans", "ChrisEvans@vs.com");
			
			// Add students to the course.
			c.addStudent(s1);
			c.addStudent(s2);
			c.addStudent(s3);
			
			// Save the students.
			System.out.println("\nSaving students...");
			session.save(s1);
			session.save(s2);
			session.save(s3);
			System.out.println("Saved students: " + c.getStudents());
			
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
