package com.sboot.crud.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sboot.crud.model.StudentModel;

public interface StudentService {

	public StudentModel addStud(StudentModel sm);

	public StudentModel updateStud(StudentModel sm);

	public ResponseEntity<StudentModel> deleteStud(StudentModel sm);

	public StudentModel viewStud(StudentModel sm);

	public List<StudentModel> viewStud();
}
