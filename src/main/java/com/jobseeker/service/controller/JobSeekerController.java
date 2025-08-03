package com.jobseeker.service.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobseeker.service.dtos.JobSeekerDTO;
import com.jobseeker.service.service.JobSeekerService;

@RestController
@RequestMapping("/api/jobseekerdata")
public class JobSeekerController {

	@Autowired
	private JobSeekerService jobSeekerService;

	@GetMapping("/jobseeker/{jobseekerId}")
	public ResponseEntity<JobSeekerDTO> getJobSeeker(@PathVariable UUID jobseekerId) {
		return new ResponseEntity<>(jobSeekerService.getJobSeekerById(jobseekerId), HttpStatus.OK);
	}
	
	@GetMapping("/jobseekers")
	public ResponseEntity<List<JobSeekerDTO>> getJobSeekers(){
		return new ResponseEntity<>(jobSeekerService.getAllJobSeekers(),HttpStatus.OK);
	}
}
