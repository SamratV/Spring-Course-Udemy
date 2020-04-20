package com.vs.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vs.aopdemo.dao.AccountDAO;
import com.vs.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// Read spring config java class.
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// Get the bean from spring container.
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// Call the business method.
		accountDAO.addAccount();
		membershipDAO.addAccount();

		// Close the context.
		context.close();
	}
}
