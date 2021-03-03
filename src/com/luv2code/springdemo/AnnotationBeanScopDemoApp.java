package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Default Scope is Singleton
		
		// retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		Coach alphaCoach = context.getBean("tennisCoach",Coach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		//print out the results
		System.out.println("Pointing to the same object "+result);
		
		System.out.println("Memory Loacation for theCoach is "+theCoach);
		
		System.out.println("Memory Location for alphaCoach is "+alphaCoach);
		
		// close the context
		context.close();
	
	}

}
