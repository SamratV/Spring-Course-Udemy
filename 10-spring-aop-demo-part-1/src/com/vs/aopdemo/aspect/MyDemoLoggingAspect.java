package com.vs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect		// To specify that this is an aspect class.
@Component	// To make the class discoverable during component scan.
public class MyDemoLoggingAspect {

	// SKIPPED CODE: Read the PDFs to know more about the pointcut expressions and @Pointcut.
	/*
	 * IMPORTANT:
	 * 
	 * @Before("execution(* add*(com.vs.aopdemo.Account, ..))"):
	 * 
	 * First parameter's type is specified and the rest of the parameters
	 * could be anything & in any number.
	 * 
	 */
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n>>> Executing @Before advice on addAccount().\n");
	}
}
