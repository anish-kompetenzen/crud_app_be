package com.sboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sboot.crud.model.StudentModel;
import com.sboot.crud.repository.StudentRepository;

@Service
// ignoring this causes error since service class is to be specified
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public StudentModel addStud(StudentModel sm) {
		return repository.save(sm);
	}

	@Override
	public StudentModel updateStud(StudentModel sm) {
		return repository.save(sm);
	}

	@Override
	public ResponseEntity<StudentModel> deleteStud(StudentModel sm) {
		Optional<StudentModel> op = repository.findById(sm.getStudentId());
		if (op.isPresent() && op != null) {
			repository.delete(op.get());
			return new ResponseEntity<StudentModel>(op.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudentModel>(new StudentModel(), HttpStatus.BAD_REQUEST);
	}

	@Override
	public StudentModel viewStud(StudentModel sm) {
		Optional<StudentModel> op = repository.findById(sm.getStudentId());
		if (op.isPresent() && op != null) {
			return op.get();
		}
		return new StudentModel();
	}

	@Override
	public List<StudentModel> viewStud() {
		return repository.findAll();
	}
}
