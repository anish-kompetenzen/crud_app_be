package com.sboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sboot.crud.model.StudentModel;
import com.sboot.crud.service.StudentService;

import jakarta.websocket.server.PathParam;

@RestController // http://localhost:8080/ : baseURL
@RequestMapping("crud") // http://localhost:8080/crud : updated baseURL
@CrossOrigin("http://localhost:3000")
public class CrudController {

	@Autowired
	private StudentService service;

	@PostMapping("insert") // http://localhost:8080/crud/insert // data to be received is JSON
	public ResponseEntity<StudentModel> insertStudent(@RequestBody StudentModel sm) {
		//{
		//	"studentName" : "Anish",
		//	"studentAge" : 26,
		//	"studentPlace" : "TVM"
		//}
		return new ResponseEntity<StudentModel>(service.addStud(sm), HttpStatus.CREATED);
	}

	@GetMapping("view") // http://localhost:8080/crud/view
	public ResponseEntity<List<StudentModel>> viewStudents() {
		return new ResponseEntity<List<StudentModel>>(service.viewStud(), HttpStatus.OK);
	}

	@GetMapping("viewone") // http://localhost:8080/crud/viewone?id=1&name=Akhil
	public ResponseEntity<StudentModel> viewStudent(@PathParam("id") Integer id) {
		return new ResponseEntity<StudentModel>(service.viewStud(new StudentModel(id, "", 0, "")), HttpStatus.OK);
	}

	@PutMapping("update") // http://localhost:8080/crud/update
	public ResponseEntity<StudentModel> updateStudent(@RequestBody StudentModel sm) {
		return new ResponseEntity<StudentModel>(service.updateStud(sm), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("delete/{id}") // http://localhost:8080/crud/delete/1
	public ResponseEntity<StudentModel> deleteStudent(@PathVariable("id") Integer id) {
		return service.deleteStud(new StudentModel(id, "", 0, ""));
	}
}
