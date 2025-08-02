package com.jobseeker.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobseeker.service.model.CustomUserDetails;
import com.jobseeker.service.model.JobSeeker;
import com.jobseeker.service.repository.JobSeekerRepository;

@Service
public class UserDetailServiceImplementation implements UserDetailsService {

	@Autowired
	private JobSeekerRepository jobSeekerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email)
	            .orElseThrow(() -> new UsernameNotFoundException("JobSeeker not found with email: " + email));

	    return new CustomUserDetails(jobSeeker);
	}



}
