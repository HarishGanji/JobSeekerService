package com.jobseeker.service.globalexception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.jobseeker.service.exceptions.JobSeekerNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(JobSeekerNotFoundException.class)
	public ResponseEntity<Object> handleJobSeekerNotFound(JobSeekerNotFoundException ex) {
		return buildErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
		return buildErrorResponse("Invalid type: " + ex.getValue(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGeneralException(Exception ex) {
		return buildErrorResponse("Something went wrong: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> buildErrorResponse(String message, HttpStatus status) {
		Map<String, Object> error = new HashMap<>();
		error.put("timestamp", LocalDateTime.now());
		error.put("status", status.value());
		error.put("error", status.getReasonPhrase());
		error.put("message", message);
		return new ResponseEntity<>(error, status);
	}
}