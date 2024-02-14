package com.ty.TrackYantra.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.TrackYantra.dto.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler {
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(DesignationNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> designationNotFoundException(DesignationNotFoundException exception)
	{
		ResponseStructure<String> resp= new  ResponseStructure<String>();
		resp.setMessage(exception.getMessage());
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
		
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> designationNotFoundException(IdNotFoundException exception)
	{
		ResponseStructure<String> resp= new  ResponseStructure<String>();
		resp.setMessage(exception.getMessage());
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);	
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> designationNotFoundException(EmailNotFoundException exception)
	{
		ResponseStructure<String> resp= new  ResponseStructure<String>();
		resp.setMessage(exception.getMessage());
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);	
	}

}
