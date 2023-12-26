package com.app.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddStudentdto {
	private String FirstName;
	private String lastName;
	private String email;
	private String password;
	private Long Course_Id;
}
