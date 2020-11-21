package com.learn2grow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn2grow.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
	
}
