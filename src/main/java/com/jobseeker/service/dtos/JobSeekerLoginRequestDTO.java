package com.jobseeker.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerLoginRequestDTO {
	
	private String email;
	private String password;
}
