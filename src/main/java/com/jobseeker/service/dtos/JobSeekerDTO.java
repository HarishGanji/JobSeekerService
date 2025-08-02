package com.jobseeker.service.dtos;

import java.util.List;
import java.util.UUID;

import com.jobseeker.service.model.Education;
import com.jobseeker.service.model.Experience;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerDTO {

	private UUID jobSeekerId;
	private String fullName;
	private String email;
	private String mobile;
	private List<Experience> experience;
	private List<Education> education;

}
