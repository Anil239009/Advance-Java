package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddStudentdto;
import com.app.dto.ApiResponsedto;
import com.app.service.StudentService;

@RestController
@RequestMapping("/Studnts")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public AddStudentdto addNewStudent(AddStudentdto student) {
		return studentService.addNewStudent(student);
	}
	@DeleteMapping("/{Student_id}")
	public ResponseEntity<?> deleteStudent(Long Student_id){
		try {
			return ResponseEntity.ok(new ApiResponsedto(studentService.deleteStudent(Student_id)));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponsedto(e.getMessage()));
		}	
	}
	@GetMapping
	public List<AddStudentdto> getAllStudent(){
		return studentService.getAllStudent();
	}
}
