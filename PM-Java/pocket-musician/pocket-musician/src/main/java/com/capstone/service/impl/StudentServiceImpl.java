package com.capstone.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.entity.Student;
import com.capstone.repository.StudentRepository;
import com.capstone.service.StudentService;

import javassist.NotFoundException;

public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student findByEmail(String email) {
		
		Student student;
		try {
			student = studentRepository.findByEmail(email).get();
		} catch(RuntimeException e) {
			throw new RuntimeException("Student not found for email: " + email );
		}
		
		return student;
	
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);	
	}

	@Override
	public Student login(Student student) {
		// TODO Auto-generated method stub
		Optional<Student> currentStudent = studentRepository.findByEmail(student.getEmail());
		
		if(currentStudent.isPresent()) {
			if(currentStudent.get().getPassword().equals(student.getPassword())) {
				return currentStudent.get();
			} else {
				return null;
			}
		} else {
			return null;
		}
	
	}

}
