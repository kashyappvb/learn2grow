package com.learn2grow.exception;

import java.util.List;

public class CustomException {
	private int code;
	private String msg;
	private List<String> details;
	
	public CustomException(int code, String msg, List<String> details) {
		//super();
		this.code = code;
		this.msg = msg;
		this.details = details;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getDetails() {
		return details;
	}
	public void setDetails(List<String> details) {
		this.details = details;
	}
	
	
}
