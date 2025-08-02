package com.jobseeker.service.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jobseeker.service.exceptions.EducationNotFoundException;
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;

//@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler({JobSeekerNotFoundException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(JobSeekerNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    
    @ExceptionHandler({EducationNotFoundException.class})
    public ResponseEntity<Object> handleStudentAlreadyExistsException(EducationNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}