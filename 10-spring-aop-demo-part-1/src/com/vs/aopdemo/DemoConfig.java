package com.vs.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration						// To inform that this is config class.
@EnableAspectJAutoProxy 			// To enable AspectJ.
@ComponentScan("com.vs.aopdemo") 	// To specify component scan path.
public class DemoConfig {

}
