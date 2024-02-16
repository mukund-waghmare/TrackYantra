package com.ty.TrackYantra.exception;

public class LocationIdNotFoundException extends RuntimeException {
	
	String message;
	
	public LocationIdNotFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	

}
