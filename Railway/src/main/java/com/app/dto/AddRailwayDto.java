package com.app.dto;

import java.time.LocalDate;
import java.util.Locale.Category;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.app.pojos.TrainType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddRailwayDto {
	
	private String trainName;
	private TrainType tarinType; 
	private LocalDate start_time; 
	private LocalDate end_time;
	private String source;
	private String destiation;
	
	public AddRailwayDto()
	{
		System.out.println("In add railway Dto Ctor");
	}
	
}
