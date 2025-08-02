package com.jobseeker.service.dtos;

import java.util.UUID;

import com.jobseeker.service.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private Role role;
}
