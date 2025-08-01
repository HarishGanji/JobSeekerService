package com.jobseeker.service.serviceimplementation;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.service.dtos.EducationDTO;
import com.jobseeker.service.mapper.EducationMapper;
import com.jobseeker.service.model.Education;
import com.jobseeker.service.model.JobSeeker;
import com.jobseeker.service.repository.EducationRepository;
import com.jobseeker.service.repository.JobSeekerRepository;
import com.jobseeker.service.service.EducationService;

@Service
public class EducationServiceImplementation implements EducationService {

	@Autowired
	EducationMapper eduMapper;

	@Autowired
	JobSeekerRepository jobRepo;

	@Autowired
	EducationRepository eduRepo;

	@Override
	public EducationDTO addEducation(UUID jobSeekerId, Education education) {
		JobSeeker jobSeeker = jobRepo.getJobSeekerById(jobSeekerId);
		Education educat = new Education();
		educat.setBoardOrUniversity(education.getBoardOrUniversity());
		educat.setInstituteName(education.getInstituteName());
		educat.setLevel(education.getLevel());
		educat.setPercentage(education.getPercentage());
		educat.setYearOfPassing(education.getYearOfPassing());
		educat.setJobSeeker(jobSeeker);
		eduRepo.save(educat);
		jobSeeker.getEducation().add(educat);
		return eduMapper.toDto(educat);
	}

}
