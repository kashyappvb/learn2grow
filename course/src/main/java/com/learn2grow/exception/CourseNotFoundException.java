package com.learn2grow.exception;

import java.util.List;

public class CourseNotFoundException extends CustomSkeletonException {

	public CourseNotFoundException(int code, String msg, List<String> details) {
		super(code, msg, details);
		
	}
}
