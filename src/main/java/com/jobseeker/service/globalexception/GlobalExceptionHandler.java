package com.jobseeker.service.globalexception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import com.jobseeker.service.security.UserDetailServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;
import com.jobseeker.service.exceptions.OTPException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final UserDetailServiceImplementation userDetailServiceImplementation;
    private final WebMvcConfigurer webMvcConfigurer;

    public GlobalExceptionHandler(WebMvcConfigurer webMvcConfigurer,
                                  UserDetailServiceImplementation userDetailServiceImplementation) {
        this.webMvcConfigurer = webMvcConfigurer;
        this.userDetailServiceImplementation = userDetailServiceImplementation;
    }

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

	@ExceptionHandler(OTPException.class)
	public ResponseEntity<Object> handleOTPException(Exception ex){
		return buildErrorResponse("something went wrong: "+ ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
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