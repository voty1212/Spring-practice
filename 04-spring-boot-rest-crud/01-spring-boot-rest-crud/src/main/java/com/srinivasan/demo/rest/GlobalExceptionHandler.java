package com.srinivasan.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //add exception handler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handler(StudentNotFoundException e){
        //create a StudentErrrorResponse
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());



        //return response to user
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    //Another exception for all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleex(Exception e){
        StudentErrorResponse error=new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());



        //return response to user
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
