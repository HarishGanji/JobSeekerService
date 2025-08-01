package com.jobseeker.service.service;

import java.util.UUID;

import com.jobseeker.service.dtos.EducationDTO;
import com.jobseeker.service.model.Education;

public interface EducationService {
	
	EducationDTO addEducation(UUID jobSeekerId, Education education);
}
