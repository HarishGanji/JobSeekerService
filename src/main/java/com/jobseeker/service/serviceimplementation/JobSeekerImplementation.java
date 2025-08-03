package com.jobseeker.service.serviceimplementation;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.service.dtos.JobSeekerDTO;
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;
import com.jobseeker.service.mapper.JobSeekerMapper;
import com.jobseeker.service.model.JobSeeker;
import com.jobseeker.service.repository.JobSeekerRepository;
import com.jobseeker.service.service.JobSeekerService;

@Service
public class JobSeekerImplementation implements JobSeekerService{

	@Autowired
	private JobSeekerRepository jobRepo;
	
	@Autowired
	private JobSeekerMapper jobMapper;
	@Override
	public JobSeekerDTO getJobSeekerById(UUID jobSeekerId) throws JobSeekerNotFoundException{
		return jobMapper.toDto(jobRepo.findById(jobSeekerId).orElseThrow(()->new JobSeekerNotFoundException("Job seeker not found with Id: "+ jobSeekerId)));
	}

	@Override
	public List<JobSeekerDTO> getAllJobSeekers() throws JobSeekerNotFoundException {
		List<JobSeeker> jobseekers = jobRepo.getAllJobSeekers();
		return jobMapper.toDtoList(jobseekers);
	}

}
