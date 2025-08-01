package com.jobseeker.service.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobseeker.service.dtos.EducationDTO;
import com.jobseeker.service.model.Education;
import com.jobseeker.service.service.EducationService;


@RestController
@RequestMapping("/api/jobseekers")
public class EducationController {
	
	@Autowired
	EducationService educationServ;
	
	
	@PostMapping("/jobseeker/{jobSeekerId}")
	public ResponseEntity<EducationDTO> addEducation(@PathVariable UUID jobSeekerId,@RequestBody Education education){
		return new ResponseEntity<>(educationServ.addEducation(jobSeekerId, education),HttpStatus.OK);
	}
	
}
