package com.app.service;



import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentDao;
import com.app.dto.AddStudentdto;
import com.app.pojos.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	ModelMapper mapper;
	@Override
	public AddStudentdto addNewStudent(AddStudentdto student) {
		studentDao.save(mapper.map(student, Student.class));
		return student;
	}
	@Override
	public String deleteStudent(Long id) {
		if(studentDao.existsById(id)) {
			studentDao.deleteById(id);
			return "Student deleted Successfully..!";
		}
		return "Invalid Student id";
	}
	@Override
	public List<AddStudentdto> getAllStudent() {
		List<AddStudentdto>list=studentDao.findAll().stream().map(e->mapper.map(e, AddStudentdto.class)).collect(Collectors.toList());
		return list;
	}
	
	
}
