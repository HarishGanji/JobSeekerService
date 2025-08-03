package com.jobseeker.service.serviceimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.service.dtos.ExperienceDTO;
import com.jobseeker.service.exceptions.JobSeekerNotFoundException;
import com.jobseeker.service.mapper.ExperienceMapper;
import com.jobseeker.service.model.Experience;
import com.jobseeker.service.model.JobSeeker;
import com.jobseeker.service.repository.ExperienceRepository;
import com.jobseeker.service.repository.JobSeekerRepository;
import com.jobseeker.service.service.ExperienceService;

@Service
public class ExperienceServiceImplementation implements ExperienceService {

	@Autowired
	private JobSeekerRepository jobRepo;

	@Autowired
	private ExperienceRepository exRepo;

	@Autowired
	private ExperienceMapper exMapper;

	@Override
	public List<ExperienceDTO> addExperience(UUID jobSeekerId, List<ExperienceDTO> experiences) {
		JobSeeker jobSeeker = jobRepo.findById(jobSeekerId)
				.orElseThrow(() -> new JobSeekerNotFoundException("Job seeker not found with ID:" + jobSeekerId));
		List<Experience> savedExperiences = new ArrayList<>();

		for (ExperienceDTO dto : experiences) {
			Experience experience = exMapper.toEntity(dto);
			experience.setJobSeeker(jobSeeker);
			savedExperiences.add(exRepo.save(experience));
		}
		jobSeeker.getExperience().addAll(savedExperiences);

		return savedExperiences.stream().map(exMapper::toDto).collect(Collectors.toList());
	}

}
