package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Courses")
public class Course extends BaseEntity {
	@Column(name = "Course_name", length = 25,unique = true)
	private String courseName;
	@Column(name = "Course_fee", nullable = false)
	private Double fees;
	@Column(name = "Course_duration",nullable = false)
	private int duration;
	@Column(name = "no_of_Student",nullable = false)
	private int noOfStudent;
//	One course has many students
	@OneToMany
	List<Student> student=new ArrayList<Student>();
}
