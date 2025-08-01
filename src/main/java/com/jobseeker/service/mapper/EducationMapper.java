package com.jobseeker.service.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.jobseeker.service.dtos.EducationDTO;
import com.jobseeker.service.model.Education;

@Mapper(componentModel = "spring")
public interface EducationMapper {
	
	EducationDTO toDto(Education education);
	
    @Mapping(target = "jobSeeker", ignore = true)
	Education toEntity(EducationDTO education);
	
}
