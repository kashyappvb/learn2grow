package com.learn2grow.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(value=CourseNotFoundException.class)
	public ResponseEntity<Object> courseNotFoundException(CourseNotFoundException e)
	{
		List<String> list = new ArrayList<String>();
		CustomException cEx = new CustomException(e.getCode(), e.getMsg(), e.getDetails());
		return new ResponseEntity<Object>(cEx, HttpStatus.NOT_FOUND);
	}
}
