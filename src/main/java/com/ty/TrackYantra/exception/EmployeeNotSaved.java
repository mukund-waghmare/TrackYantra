package com.ty.TrackYantra.exception;

public class EmployeeNotSaved extends RuntimeException{

    private String message;
	
	public EmployeeNotSaved(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
