package com.jobseeker.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jobseeker.service.dtos.ExperienceDTO;
import com.jobseeker.service.model.Experience;

@Mapper(componentModel = "spring")
public interface ExperienceMapper {

	ExperienceDTO toDto(Experience experience);
	
	@Mapping(target = "jobSeeker",ignore = true)
	Experience toEntity(ExperienceDTO dto);
}
