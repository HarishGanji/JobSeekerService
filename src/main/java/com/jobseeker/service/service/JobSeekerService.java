package com.jobseeker.service.service;

import java.util.List;
import java.util.UUID;

import com.jobseeker.service.dtos.JobSeekerDTO;

public interface JobSeekerService {
	
	JobSeekerDTO getJobSeekerById(UUID jobSeekerId);
	
	List<JobSeekerDTO> getAllJobSeekers();
}
