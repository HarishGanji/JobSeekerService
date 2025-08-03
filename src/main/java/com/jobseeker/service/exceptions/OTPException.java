package com.jobseeker.service.exceptions;

public class OTPException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OTPException(String message) {
	        super(message); // Use the provided message
	    }

}
