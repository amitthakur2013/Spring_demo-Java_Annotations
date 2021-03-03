package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component //(write the id for the bean)
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
