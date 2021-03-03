package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //(write the id for the bean)
//@Scope("prototype") //singleton | prototype
public class TennisCoach implements Coach {
	
	
	//Field injection direct injection also to private one
	@Autowired
	@Qualifier("randomFortuneService") //for multiple beans specify the bean id
	private FortuneService fortuneService;
	
	/*Costructor Injection*/
	//@Autowired
	/*public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}*/
	
	//define a default constructor
	public TennisCoach() {
		System.out.println("Inside TennisCoach consructor");
		
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Inside doMystartupStuff: Tennis Coach");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("Inside do my cleanup stuff: TennisCoach");
	}
	
	// Setter injection using autowired annotation
	/*@Autowired
	public void setFortuneService(FortuneService fortuneService){
		System.out.println("Tennis Coach: Inside setter method of fortune service dependency injection!");
		this.fortuneService=fortuneService;
	}*/

	@Override 
	public String getDailyWorkout() {
		return "Practice your backhand volley: Tennis Coach";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
