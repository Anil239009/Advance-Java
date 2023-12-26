package com.app.service;

import java.util.List;

import com.app.dto.addCoursedto;

public interface CourseService {
	addCoursedto addNewCourse(addCoursedto course);
	String deleteCourseById (Long id);
	List<addCoursedto> getAllCourse();
}
