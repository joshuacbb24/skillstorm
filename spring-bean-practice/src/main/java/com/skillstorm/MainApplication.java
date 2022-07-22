package com.skillstorm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
	
		Object sword = context.getBean("weapon");
		
		((AbstractApplicationContext) context).close();
	
	}
	
	
}
