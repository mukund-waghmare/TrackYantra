package com.ty.TrackYantra.exception;


public class ImageSizeExceedException extends RuntimeException{
	
	String message;
	
	public ImageSizeExceedException(String message) {
			this.message=message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
