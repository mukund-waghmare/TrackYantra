package com.ty.TrackYantra.exception;

public class InvalidEmployeeCredentialsException extends RuntimeException{
	
	 private String message;
		
		public InvalidEmployeeCredentialsException(String message) {
			
			this.message=message;
		}
		
		@Override
		public String getMessage() {
			
			return super.getMessage();
		}

}
