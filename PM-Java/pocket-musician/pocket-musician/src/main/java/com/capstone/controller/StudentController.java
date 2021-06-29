package com.capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.entity.Student;
import com.capstone.service.impl.StudentServiceImpl;

@CrossOrigin
@RestController
public class StudentController {
	
	private StudentServiceImpl studentService;
	
	@Autowired
	public StudentController(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(value="/saveStudent", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveStudent(@RequestBody Student student) {
		studentService.save(student);
	}
	
	@RequestMapping(value="/findStudentByEmail", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<Student> findStudent(String email) {
		return new ResponseEntity<>(studentService.findByEmail(email), HttpStatus.OK);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Student> login(@RequestBody Student studentRequest) {
		
		Student student = studentService.login(studentRequest);
		
		if(student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}
