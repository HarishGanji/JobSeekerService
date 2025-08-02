package com.jobseeker.service.controller;

import java.util.List;
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
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;
import com.jobseeker.service.model.Education;
import com.jobseeker.service.service.EducationService;



@RestController
@RequestMapping("/api/educationDetails")
public class EducationController {
	
	@Autowired
	EducationService educationServ;
	
	
	@PostMapping("/{jobSeekerId}/education")
	public ResponseEntity<EducationDTO> addEducation(@PathVariable UUID jobSeekerId,@RequestBody Education education) {
		return new ResponseEntity<>(educationServ.addEducation(jobSeekerId, education),HttpStatus.OK);
	}
	
	@PostMapping("/{jobSeekerId}/savededucations")
	public ResponseEntity<List<EducationDTO>> savedEducations(@PathVariable UUID jobSeekerId, @RequestBody List<EducationDTO> educations) {
		return new ResponseEntity<>(educationServ.addEducationDetails(jobSeekerId, educations),HttpStatus.OK);
	}
}
