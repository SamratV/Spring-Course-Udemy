package com.vs.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.vs.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	
	// Set up variable to hold the properties.
	@Autowired
	private Environment env; // It will hold the data read from properties file.
	
	// Set up a logger for diagnostics.
	private Logger logger = Logger.getLogger(getClass().getName());

	// Define a bean for ViewResolver.
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// Define a bean for our security datasource.
	@Bean
	public DataSource securityDataSource() {
		// Create connection pool.
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		// Set the JDBC driver class.
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// RuntimeException is unchecked, so crash will be detected. Not using
			// "throws" in method signature will prevent further exception handling.
			throw new RuntimeException(e);
		}
		
		// Log the connection properties.
		logger.info(">>>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		// Set database connection properties.
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// Set connection pool properties.
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getIntProperty(String p) {
		return Integer.parseInt(env.getProperty(p));
	}
	
}
