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

import com.capstone.entity.Course;
import com.capstone.entity.Student;
import com.capstone.service.CourseService;
import com.capstone.service.impl.CourseServiceImpl;

@CrossOrigin
@RestController
public class CourseController {
	
private CourseServiceImpl courseService;
	
	@Autowired
	public CourseController(CourseServiceImpl courseService) {
		this.setCourseService(courseService);
	}
	
	@RequestMapping(value="/saveCourse", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveCourse(@RequestBody Course course) {
	CourseService.save(course);
	}
	
	@RequestMapping(value="/findCoursebyName", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	private ResponseEntity<Student> findStudent(String name) {
		return new ResponseEntity<Student>(HttpStatus.OK);
	}

	public CourseServiceImpl getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseServiceImpl courseService) {
		this.courseService = courseService;
	}
	
}
