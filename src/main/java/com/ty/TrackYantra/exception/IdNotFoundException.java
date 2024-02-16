package com.ty.TrackYantra.exception;

public class IdNotFoundException extends RuntimeException {
	
	String message;
	
	public IdNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
