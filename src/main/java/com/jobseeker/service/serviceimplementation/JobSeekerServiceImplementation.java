package com.jobseeker.service.serviceimplementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobseeker.service.dtos.JobSeekerLogInResponseDTO;
import com.jobseeker.service.dtos.JobSeekerLoginRequestDTO;
import com.jobseeker.service.dtos.JobSeekerRegisterRequestDTO;
import com.jobseeker.service.dtos.JobSeekerResponseDTO;
import com.jobseeker.service.mapper.JobSeekerMapper;
import com.jobseeker.service.model.CustomUserDetails;
import com.jobseeker.service.model.JobSeeker;
import com.jobseeker.service.repository.JobSeekerRepository;
import com.jobseeker.service.security.JwtUtil;
import com.jobseeker.service.service.JobSeekerService;

@Service
public class JobSeekerServiceImplementation implements JobSeekerService {

	@Autowired
	private JobSeekerRepository jobRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JobSeekerMapper jobSeekerMapper;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public JobSeekerResponseDTO registerJobSeeker(JobSeekerRegisterRequestDTO request) {
		JobSeeker jobSeeker = JobSeeker.builder().fullName(request.getFullName()).email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword())).build();
		JobSeeker saved = jobRepo.save(jobSeeker);
		return JobSeekerResponseDTO.builder().jobSeekerId(saved.getJobSeekerId()).fullName(saved.getFullName())
				.email(saved.getEmail()).build();
	}

	@Override
	public JobSeekerLogInResponseDTO login(JobSeekerLoginRequestDTO loginRequest) {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		JobSeeker jobseeker = jobRepo.findByEmail(loginRequest.getEmail())
				.orElseThrow(() -> new IllegalStateException("User not found after authentication"));
		String token = jwtUtil.generateToken(new CustomUserDetails(jobseeker));
		JobSeekerLogInResponseDTO jobSeekerResponse = new JobSeekerLogInResponseDTO();
		jobSeekerResponse.setJobSeekerId(jobseeker.getJobSeekerId());
		jobSeekerResponse.setToken(token);
		jobSeekerResponse.setFullName(jobseeker.getFullName());
		jobSeekerResponse.setEmail(jobseeker.getEmail());
		return jobSeekerResponse;

	}

}
