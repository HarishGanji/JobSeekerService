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

import com.jobseeker.service.dtos.ExperienceDTO;
import com.jobseeker.service.service.ExperienceService;

@RestController
@RequestMapping("api/experience")
public class ExperienceController {

	@Autowired
	private ExperienceService expServ;
	
	@PostMapping("/{jobSeekerId}/savedexperiences")
	public ResponseEntity<List<ExperienceDTO>> saveExperiences(@PathVariable UUID jobSeekerId,@RequestBody List<ExperienceDTO> experiences) {
	    return new ResponseEntity<>(expServ.addExperience(jobSeekerId, experiences), HttpStatus.OK);
	}
	
}
