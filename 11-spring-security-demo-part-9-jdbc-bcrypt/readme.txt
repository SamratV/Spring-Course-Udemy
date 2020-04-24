NOTE:
	1) Spring Security Taglib's dependency was added to pom.xml.
	2) "DemoSecurityConfig.java" was updated.
	3) Restricting users on a page based on roles. (IMPORTANT)
	4) Custom error page is also included. (IMPORTANT)
	
PREVIOUS PROJECT STEPS:
	1) Run the "STARTER FILES/sql-scripts/setup-spring-security-demo-database-plaintext.sql" file.
	2) Add MySQL and C3P0 support to pom.xml.
	3) Copy "STARTER FILES/src/main/resources" and paste it to "src/main" (PROPERTIES FILE). "src/main/resources" is a standard MAVEN directory.
	
	(DemoAppConfig.java)
	4) Add " @PropertySource("classpath:persistence-mysql.properties").
	5) Define and autowire "private Environment env" variable.
	6) OPTIONAL: Set up a logger for diagnostics.
	7) Define a bean for our security datasource. 
	
	(DemoSecurityConfig.java)
	8) Add a reference to our security data source.
	9) Modify "configure(AuthenticationManagerBuilder auth)" method.

CURRENT STEPS:
	1) Run the "STARTER FILES/sql-scripts/setup-spring-security-bcrypt-demo-database.sql" file.
	2) Update the DB name part of URL to "spring_security_demo_bcrypt" in "src/main/resources/persistence-mysql.properties".