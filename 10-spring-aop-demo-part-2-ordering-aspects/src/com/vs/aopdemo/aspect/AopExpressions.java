package com.vs.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	 @Pointcut("execution(* com.vs.aopdemo.dao.*.*(..))")
	 public void forDaoPackage() {}
	 
	 // Create pointcut for getter methods.
	 @Pointcut("execution(* com.vs.aopdemo.dao.*.get*(..))")
	 public void getter() {}
	 
	 // Create pointcut for setter methods.
	 @Pointcut("execution(* com.vs.aopdemo.dao.*.set*(..))")
	 public void setter() {}
	 
	 // Create pointcut: include package but exclude getter / setter methods.
	 @Pointcut("forDaoPackage() && !(getter() || setter())")
	 public void forDaoPackageNoGetterSetter() {}
}
