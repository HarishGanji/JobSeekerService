package com.jobseeker.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobseeker.service.dtos.JobSeekerLogInResponseDTO;
import com.jobseeker.service.dtos.JobSeekerLoginRequestDTO;
import com.jobseeker.service.dtos.JobSeekerRegisterRequestDTO;
import com.jobseeker.service.dtos.JobSeekerResponseDTO;
import com.jobseeker.service.service.JobSeekerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/jobseekers/auth")
//@RequiredArgsConstructor
public class JobSeekerAuthController {

	@Autowired
    private JobSeekerService jobSeekerService;
//	@Autowired
//    private JwtUtil jwtUtil;
//	@Autowired
//    private AuthenticationManager authenticationManager;
//	@Autowired
//    private JobSeekerRepository jobSeekerRepository;

	@PostMapping("/register")
	public ResponseEntity<JobSeekerResponseDTO> register(@RequestBody @Valid JobSeekerRegisterRequestDTO request) {
	    JobSeekerResponseDTO response = jobSeekerService.registerJobSeeker(request);
	    return ResponseEntity.ok(response);
	}

    @PostMapping("/login")
    public ResponseEntity<JobSeekerLogInResponseDTO> login(@RequestBody JobSeekerLoginRequestDTO request) {
    	JobSeekerLogInResponseDTO responseDTO = jobSeekerService.login(request);
        return ResponseEntity.ok(responseDTO);
    }


}