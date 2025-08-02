package com.jobseeker.service.exceptions;

public class JobSeekerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public JobSeekerNotFoundException(String message) {
        super(message); // Use the provided message
    }
}