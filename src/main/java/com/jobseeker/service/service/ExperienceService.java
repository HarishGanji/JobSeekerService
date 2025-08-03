package com.jobseeker.service.service;

import java.util.List;
import java.util.UUID;

import com.jobseeker.service.dtos.ExperienceDTO;

public interface ExperienceService {
	
	List<ExperienceDTO> addExperience(UUID jobSeekerId, List<ExperienceDTO> experiences);
}
