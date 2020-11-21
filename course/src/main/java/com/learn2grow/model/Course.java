package com.learn2grow.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int courseId;
	
	private String courseName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="priceId",referencedColumnName="priceId")
	private Price price;
	
	public Course() {}
	
	public Course(int courseId, String courseName, Price price) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.price = price;
	}
	
	public int getId() {
		return courseId;
	}
	public void setId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Price getPrice() {
		return price;
	}
	public void setPrice(Price price) {
		this.price = price;
	}	
}
