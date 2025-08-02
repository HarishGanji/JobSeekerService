package com.jobseeker.service.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {

	private UUID educationId;
	private String level;
    private String board;
    private String instituteName;
    private String yearOfPassing;
    private Double percentage;

}
