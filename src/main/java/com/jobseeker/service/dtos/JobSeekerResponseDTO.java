package com.jobseeker.service.dtos;

import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobSeekerResponseDTO {
	
	private UUID jobSeekerId;
	private String fullName;
	private String email;
	
}
