package com.ty.TrackYantra.exception;


public class EmailNotFoundException extends RuntimeException {
	
	private String message;
	
	public EmailNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	

}
