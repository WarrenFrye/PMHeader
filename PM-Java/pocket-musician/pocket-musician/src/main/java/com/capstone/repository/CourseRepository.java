package com.capstone.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.entity.Course;

	@Repository
	public interface CourseRepository extends JpaRepository<Course, Long> {

		Optional<Course> findByName(String name);
}
