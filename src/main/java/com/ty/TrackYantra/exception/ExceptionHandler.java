package com.ty.TrackYantra.exception;

<<<<<<< HEAD
<<<<<<< HEAD
=======
import com.ty.TrackYantra.dto.ResponseStructure;
>>>>>>> 7d0d9346d9ceeae808195ac6c8fbc71eae4118ac
=======

import com.ty.TrackYantra.dto.ResponseStructure;

>>>>>>> 38c532ab7e6d92f654e98e30372459008d5bc05c
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.TrackYantra.dto.ResponseStructure;

@RestControllerAdvice
public class ExceptionHandler {
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 38c532ab7e6d92f654e98e30372459008d5bc05c
	
	
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
<<<<<<< HEAD
=======
=======

>>>>>>> 38c532ab7e6d92f654e98e30372459008d5bc05c
    @org.springframework.web.bind.annotation.ExceptionHandler(ReportingManagerNotFound.class)
    public ResponseEntity<ResponseStructure<String>> reportingManagerNotFoundException(ReportingManagerNotFound reportingManagerNotFound){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(reportingManagerNotFound.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
    }
<<<<<<< HEAD
>>>>>>> 7d0d9346d9ceeae808195ac6c8fbc71eae4118ac
=======

>>>>>>> 38c532ab7e6d92f654e98e30372459008d5bc05c


    @org.springframework.web.bind.annotation.ExceptionHandler(ReportingManagerNotSaved.class)
    public ResponseEntity<ResponseStructure<String>> reportingManagerNotSaved(ReportingManagerNotSaved reportingManagerNotSaved){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(reportingManagerNotSaved.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
    }
}
