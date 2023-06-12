package com.spring.myapp.dto;

public class ApiResponse {
	
	private String message;
	private int status;
	private StudentDto student;
	
	public ApiResponse(int status ,String message, StudentDto student) {
		this.status = status;
		this.message = message;
		this.student = student;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public StudentDto getStudent() {
		return student;
	}
	public void setStudent(StudentDto student) {
		this.student = student;
	}
	



}
