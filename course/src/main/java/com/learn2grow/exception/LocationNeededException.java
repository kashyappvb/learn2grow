package com.learn2grow.exception;

import java.util.List;

public class LocationNeededException extends CustomSkeletonException {

	public LocationNeededException(int code, String msg, List<String> details) {
		super(code, msg, details);
	}

	
}
