package com.ty.TrackYantra.exception;

public class InvalidAdminCredentials extends RuntimeException{

    private String message;
	
	public InvalidAdminCredentials(String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return message;
	}
}
