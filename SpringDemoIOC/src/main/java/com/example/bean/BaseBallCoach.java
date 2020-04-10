package com.example.bean;

import lombok.Setter;

@Setter
public class BaseBallCoach implements Coach 
{
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() 
	{
		return "Do daily workout";
	}

	@Override
	public String getDailyFortune() 
	{
		return fortuneService.getFortune();
	}
}
