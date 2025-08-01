package com.jobseeker.service.dtos;

import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerRegisterRequestDTO {
	
	private UUID jobSeekerId;
	private String fullName;
	private String email;
	private String password;
	private String mobile;
	private String location;
}
