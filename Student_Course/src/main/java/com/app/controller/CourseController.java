package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponsedto;
import com.app.dto.addCoursedto;
import com.app.service.CourseService;

@RestController
@RequestMapping
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@PostMapping
	public addCoursedto addNewCourse(@RequestBody addCoursedto courseDto) {
		return courseService.addNewCourse(courseDto);
	}
	
	@DeleteMapping("/{course_Id}")
	public ResponseEntity<?> deleteCourse(@PathVariable Long course_Id){
		try {
			return ResponseEntity.ok(new ApiResponsedto(courseService.deleteCourseById(course_Id)));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponsedto(e.getMessage()));
		}
	}
	@GetMapping
	public List<addCoursedto>getAllCourse(){
		return courseService.getAllCourse();
	}
	
}
