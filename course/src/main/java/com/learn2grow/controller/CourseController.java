package com.learn2grow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn2grow.exception.CourseNotFoundException;
import com.learn2grow.model.Course;
import com.learn2grow.model.Price;
import com.learn2grow.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> getAllCourses()
	{
		return courseService.getAllCourses();
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course)
	{
		return courseService.addCourse(course);
		
	}
	
	@GetMapping("/courses/{courseId}/price")
	public Price getPriceForCourse(@PathVariable int courseId,@RequestParam(value="location",defaultValue="IND") String location)
	{ 
		return courseService.getPriceForCourse(courseId,location);
	}
}
