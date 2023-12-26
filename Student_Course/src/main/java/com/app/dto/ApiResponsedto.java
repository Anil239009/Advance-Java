package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApiResponsedto {
	private String msg;
	private LocalDate timeStamp;
	
	public ApiResponsedto( String msg) {
		this.msg=msg;
		this.timeStamp=LocalDate.now();
	
	}
}
