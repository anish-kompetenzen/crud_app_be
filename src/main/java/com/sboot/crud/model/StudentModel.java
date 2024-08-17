package com.sboot.crud.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// automatically create this table in the database
@Table(name = "student_details")
// table name should be specified as beanclassname_details
public class StudentModel {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// auto increment
	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "student_name")
	private String studentName;

	@Column(name = "student_age")
	private Integer studentAge;

	@Column(name = "student_place")
	private String studentPlace;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentPlace() {
		return studentPlace;
	}

	public void setStudentPlace(String studentPlace) {
		this.studentPlace = studentPlace;
	}

	public StudentModel(Integer studentId, String studentName, Integer studentAge, String studentPlace) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentPlace = studentPlace;
	}

	public StudentModel() {
	}

	@Override
	public String toString() {
		return "StudentModel [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentPlace=" + studentPlace + "]";
	}

	public static void main(String[] args) throws JsonProcessingException {
		System.out.println(new ObjectMapper().writeValueAsString(new StudentModel()));
//		StudentModel sm = new StudentModel();
//		sm.getStudentAge();
	}
}
