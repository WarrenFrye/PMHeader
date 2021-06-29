package com.capstone.service;

import java.util.List;

import com.capstone.entity.Course;

public interface CourseService {
	
	Course findByName(String name);
	void delete(long id);
	List<Course> findAll();
	static void save(Course course) {
		
	}
	Course update(Course course, long id);
	
}
