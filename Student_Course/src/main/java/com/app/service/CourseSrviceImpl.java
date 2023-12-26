package com.app.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseDao;
import com.app.dto.addCoursedto;
import com.app.pojos.Course;
@Service
@Transactional
public class CourseSrviceImpl implements CourseService {
	@Autowired
	private CourseDao courseDao;
	@Autowired
	ModelMapper mapper;
	@Override
	public addCoursedto addNewCourse(addCoursedto course) {
		courseDao.save(mapper.map(course, Course.class));
		return course;
	}
	@Override
	public String deleteCourseById(Long id) {
		if(courseDao.existsById(id)) {
			courseDao.deleteById(id);
			return "Course deleted sucessfully";
		}
		return "Invalid course Id";
	}
	@Override
	public List<addCoursedto> getAllCourse() {
		List<addCoursedto>list=courseDao.findAll().stream().map(e->mapper.map(e, addCoursedto.class)).collect(Collectors.toList());
		System.out.println(list);
		return list;
	}

}
