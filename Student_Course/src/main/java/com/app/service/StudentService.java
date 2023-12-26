package com.app.service;

import java.util.List;

import com.app.dto.AddStudentdto;

public interface StudentService {
	AddStudentdto addNewStudent(AddStudentdto student);
	String deleteStudent(Long id);
	List<AddStudentdto> getAllStudent();
}
