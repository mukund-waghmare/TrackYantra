package com.ty.TrackYantra.exception;

public class EmployeeNotFoundException extends RuntimeException{

    private String message;
	
	public EmployeeNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
