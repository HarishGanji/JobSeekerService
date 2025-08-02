package com.jobseeker.service.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.service.dtos.EducationDTO;
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;
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
	public EducationDTO addEducation(UUID jobSeekerId, Education education) throws JobSeekerNotFoundException {
		JobSeeker jobSeeker = jobRepo.getJobSeekerById(jobSeekerId);
		if (jobSeeker == null) {
			throw new JobSeekerNotFoundException("JobSeeker not found with ID: " + jobSeekerId);
		}
		Education educat = new Education();
		educat.setBoard(education.getBoard());
		educat.setInstituteName(education.getInstituteName());
		educat.setLevel(education.getLevel());
		educat.setPercentage(education.getPercentage());
		educat.setYearOfPassing(education.getYearOfPassing());
		educat.setJobSeeker(jobSeeker);
		eduRepo.save(educat);
		return eduMapper.toDto(educat);
	}

	@Override
	public List<EducationDTO> addEducationDetails(UUID jobSeekerId, List<EducationDTO> educationDtos) throws JobSeekerNotFoundException {
		JobSeeker jobseeker = jobRepo.getJobSeekerById(jobSeekerId);
		if (jobseeker == null) {
			throw new JobSeekerNotFoundException("JobSeeker not found with ID: " + jobSeekerId);
		}
		List<Education> savedEducations = new ArrayList<>();

		for (EducationDTO dto : educationDtos) {
			Education ed = eduMapper.toEntity(dto);
			ed.setJobSeeker(jobseeker);
//			savedEducations.add(eduRepo.save(ed));
			eduRepo.save(ed);
			savedEducations.add(ed);
		}

		jobseeker.getEducation().addAll(savedEducations);
		return savedEducations.stream().map(ed -> eduMapper.toDto(ed)).collect(Collectors.toList());
	}

}
