package com.ty.TrackYantra.exception;

import com.ty.TrackYantra.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
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
}
