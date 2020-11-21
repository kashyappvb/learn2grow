package com.learn2grow.service;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn2grow.exception.CourseNotFoundException;
import com.learn2grow.model.Course;
import com.learn2grow.model.Price;
import com.learn2grow.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses()
	{
		return courseRepository.findAll();
	}
	
	
	public Course addCourse(Course course) {
		if("FREE".equals(course.getPrice().getPricingStratergy()))
		{
			course.getPrice().setBasePrice(0);
		}
		
		return courseRepository.save(course);
	}
	
	public Price getPriceForCourse(int courseId,String location)
	{
		Optional<Course> course = courseRepository.findById(courseId);
		if(course.isPresent())
		{
			Price price = course.get().getPrice();
			if(!"IND".equals(location))
			{ 
				//Assuming Conversion Fee = 3% of Base Price and 7% of Tax for non Indians 
				double conversionFee = Math.round((price.getBasePrice() * 0.03) * 100.0)/100.0;
				double tax = Math.round((price.getBasePrice()*0.07) * 100.0)/100.0;
				price.setConversionFee(conversionFee);
				price.setTax(tax);
			}
			else
			{
				//Assuming Tax = 5% for Indians
				double tax = Math.round((price.getBasePrice()*0.05) * 100.0)/100.0;
				price.setTax(tax);
			}
			
			return price;
		}
		throw new CourseNotFoundException(404, "COURSE_NOT_FOUND", null);
	}
}
