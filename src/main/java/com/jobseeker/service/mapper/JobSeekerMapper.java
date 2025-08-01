package com.jobseeker.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jobseeker.service.dtos.JobSeekerDTO;
import com.jobseeker.service.model.JobSeeker;

@Mapper(componentModel = "spring")
public interface JobSeekerMapper {

	JobSeekerDTO toDto(JobSeeker jobSeeker);
	
    @Mapping(target = "location", ignore = true)
    @Mapping(target = "mobile", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "skill", ignore = true)
	JobSeeker toEntity(JobSeekerDTO jobseekerDto);
}
