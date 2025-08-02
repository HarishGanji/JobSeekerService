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
public class JobSeekerLogInResponseDTO {
	private UUID jobSeekerId;
	private String email;
	private String token;
	@Enumerated(EnumType.STRING)
	private Role role;

}
