package com.jobseeker.service.dtos;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDTO {

	private UUID experienceId;
	private String jobTitle;
	private String companyName;
	private String location;

	private LocalDate startDate; // From
	private LocalDate endDate; // To — can be null if currently working

	private boolean currentlyWorking; // true if currently working

	private String description;

}
