package com.jobseeker.service.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerLogInResponseDTO {
	private UUID jobSeekerId;
	private String fullName;
	private String email;
	private String token;

}
