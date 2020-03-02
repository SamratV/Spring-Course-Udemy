package com.vs.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vs.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Create session factory.
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session.
		Session session = factory.getCurrentSession();
		
		try {			
			// Start a transaction.
			System.out.println("Starting the transaction...");
			session.beginTransaction();
			
			// Query all students.
			System.out.println("\nQuerying all students...");
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// Display the students.
			displayList(students);
			
			// Query students where lastName='Walker'
			System.out.println("\nQuerying students by last name...");
			students = session.createQuery("from Student s where s.lastName='Walker'").getResultList();
			
			// Display the students.
			displayList(students);
			
			// Retrieving students using OR predicate
			System.out.println("\nRetrieving students using OR predicate...");
            students = session.createQuery("from Student s where s.lastName='Walker' OR s.firstName='Bret'").getResultList();
			
            // Display the students.
         	displayList(students);
         	
         	// Retrieving Students using LIKE predicate
         	System.out.println("\nRetrieving Students using LIKE predicate...");
            students = session.createQuery("from Student s where s.email LIKE '%vs.com'").getResultList();
         	
            // Display the students.
         	displayList(students);
         	
			// Commit transaction.
			System.out.println("Commiting the transaction...");
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
		} finally {
			factory.close();
		}
	}
	
	private static void displayList(List<Student> students) {
		for(Student st: students) {
			System.out.println(st);
		}
	}

}
