package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Students")
public class Student extends BaseEntity{
	@Column(name = "First_Name",length = 30)
	private String FirstName;
	@Column(name = "last_name",length = 30)
	private String lastName;
	@Column(length = 30,unique = true)
	private String email;
	@Column(length = 30,unique = true)
	private String password;
//	many student has one course
	@ManyToOne
	@JoinColumn(name = "Course_Id")
	@JsonIgnore
	private Course course;

}
