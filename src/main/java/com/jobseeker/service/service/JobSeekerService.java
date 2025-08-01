package com.jobseeker.service.service;


import com.jobseeker.service.dtos.JobSeekerLogInResponseDTO;
import com.jobseeker.service.dtos.JobSeekerLoginRequestDTO;
import com.jobseeker.service.dtos.JobSeekerRegisterRequestDTO;
import com.jobseeker.service.dtos.JobSeekerResponseDTO;

public interface JobSeekerService {

	JobSeekerResponseDTO registerJobSeeker(JobSeekerRegisterRequestDTO request);
	
	JobSeekerLogInResponseDTO login(JobSeekerLoginRequestDTO loginRequest);

//	List<EducationDTO> getAllEducationDetails(UUID jobSeekerId);
//	
//	EducationDTO postEducationDetails(UUID jobSeekerId);
}
