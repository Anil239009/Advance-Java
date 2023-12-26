package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ApiResponse {
	private String msg;
	private LocalDate timeStamp;
	
	public ApiResponse(String msg) {
		this.msg=msg;
		timeStamp=LocalDate.now();
	}
	
}
