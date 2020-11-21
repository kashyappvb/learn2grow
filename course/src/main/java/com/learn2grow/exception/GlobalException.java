package com.learn2grow.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	
	@ExceptionHandler(value=CourseNotFoundException.class)
	public ResponseEntity<Object> courseNotFoundException(CourseNotFoundException e)
	{
		CustomException cEx = new CustomException(e.getCode(), e.getMsg(), e.getDetails(),LocalDateTime.now());
		return new ResponseEntity<Object>(cEx, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=LocationNeededException.class)
	public ResponseEntity<Object> locationNeededFoundException(LocationNeededException e)
	{
		CustomException cEx = new CustomException(e.getCode(), e.getMsg(), e.getDetails(),LocalDateTime.now());
		return new ResponseEntity<Object>(cEx, HttpStatus.NOT_FOUND);
	}

    @ExceptionHandler(value=Exception.class)
	public ResponseEntity<Object> uncoughtException(Exception e)
	{
		CustomException cEx = new CustomException(500, "Something went wrong. Contact Admin! ", null,LocalDateTime.now());
		return new ResponseEntity<Object>(cEx, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
