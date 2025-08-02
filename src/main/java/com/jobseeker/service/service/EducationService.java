package com.jobseeker.service.service;

import java.util.List;
import java.util.UUID;

import com.jobseeker.service.dtos.EducationDTO;
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;
import com.jobseeker.service.model.Education;

public interface EducationService {
	
	EducationDTO addEducation(UUID jobSeekerId, Education education) throws JobSeekerNotFoundException;
	
	List<EducationDTO> addEducationDetails(UUID jobSeekerId, List<EducationDTO> educationDtos) throws JobSeekerNotFoundException;
}
