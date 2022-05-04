package com.smart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonProperty("first_name")
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	//@JsonIgnore
	private String email;
	
	@JoinColumn(name = "dept_id")
	@ManyToOne
	private Department department;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<SubjectsLearning> subjectsLearning;
	
	public Long getId() {
		return id;
	}

	public List<SubjectsLearning> getSubjectsLearning() {
		return subjectsLearning;
	}

	public void setSubjectsLearning(List<SubjectsLearning> subjectsLearning) {
		this.subjectsLearning = subjectsLearning;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
//	public Long getStudentId(){
//		return this.id;
//	}
	

}
