package com.app.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class addCoursedto {
	private String courseName;
	private Double fees;
	private int duration;
	private int noOfStudent;
	
	public addCoursedto() {
		System.out.println("inside addcourseDto constructor..!");
	
	}
}
