package com.capstone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capstone.entity.Course;
import com.capstone.repository.CourseRepository;
import com.capstone.service.CourseService;

public class CourseServiceImpl implements CourseService {
	
private CourseRepository courseRepository;
	
	@Autowired
	public CourseServiceImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public Course findByName(String name) {
		
		Course course;
		try {
			course = courseRepository.findByName(name).get();
		} catch(RuntimeException e) {
			throw new RuntimeException("Course not found by name: " + name );
		}
		
		return course;
	}

	
	public void save(Course course) {
		// TODO Auto-generated method stub
		courseRepository.save(course);
		
	}

	@Override
	public List<Course> findAll() {
		return courseRepository.findAll();
	}

	@Override
	public void delete(long id) {
		courseRepository.deleteById(id);
		
	}

	@Override
	public Course update(Course course, long id) {
		Course existingCourse = courseRepository.getById(id);
		
		existingCourse.setName(course.getName());
		existingCourse.setDescription(course.getDescription());
		
		courseRepository.save(existingCourse);
		return existingCourse;
	}


}
