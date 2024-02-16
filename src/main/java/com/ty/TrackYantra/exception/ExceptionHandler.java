package com.ty.TrackYantra.exception;


import com.ty.TrackYantra.dto.ResponseStructure;


import com.ty.TrackYantra.dto.ResponseStructure;

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

    @org.springframework.web.bind.annotation.ExceptionHandler(ReportingManagerNotFound.class)
    public ResponseEntity<ResponseStructure<String>> reportingManagerNotFoundException(ReportingManagerNotFound reportingManagerNotFound){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
        responseStructure.setMessage(reportingManagerNotFound.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.NOT_FOUND);
    }



    @org.springframework.web.bind.annotation.ExceptionHandler(ReportingManagerNotSaved.class)
    public ResponseEntity<ResponseStructure<String>> reportingManagerNotSaved(ReportingManagerNotSaved reportingManagerNotSaved){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(reportingManagerNotSaved.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
    }
    
    //employee related exceptions
    
    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> employeeNotFoundException(EmployeeNotFoundException employeeNotFoundException){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(employeeNotFoundException.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(EmployeeNotSaved.class)
    public ResponseEntity<ResponseStructure<String>> employeeNotSaved(EmployeeNotSaved employeeNotSaved){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(employeeNotSaved.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(NoEmployeesExistException.class)
    public ResponseEntity<ResponseStructure<String>> NoEmployeesExistException(NoEmployeesExistException noEmployeesExistException){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(noEmployeesExistException.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(InvalidAdminCredentials.class)
    public ResponseEntity<ResponseStructure<String>>InvalidAdminCredentials(InvalidAdminCredentials invalidAdminCredentials){
        ResponseStructure<String> responseStructure = new ResponseStructure<>();
        responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
        responseStructure.setMessage(invalidAdminCredentials.getMessage());
        responseStructure.setData(null);
        return new ResponseEntity<>(responseStructure,HttpStatus.BAD_REQUEST);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(LocationIdNotFoundException.class)
    public ResponseEntity<ResponseStructure<String>> locationIdNotFoundException(LocationIdNotFoundException locationIdNotFound)
    {
    	ResponseStructure<String> resp= new ResponseStructure<String>();
    	resp.setMessage(locationIdNotFound.getMessage());
    	resp.setStatusCode(HttpStatus.NOT_FOUND.value());
    	
    	return new ResponseEntity<ResponseStructure<String>>(resp,HttpStatus.NOT_FOUND);
    	
    }

    
    
}
