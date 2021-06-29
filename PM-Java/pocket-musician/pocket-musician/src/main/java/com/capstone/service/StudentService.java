package com.capstone.service;

import java.util.List;
import java.util.Optional;

import com.capstone.entity.Student;

public interface StudentService {
	
 Student findByEmail(String email);

	void save(Student student);
	Student login(Student student);

}
