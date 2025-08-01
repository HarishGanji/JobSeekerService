package com.jobseeker.service.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID experienceId;

	private String jobTitle;
	private String companyName;
	private String location;
	private String duration; 
	private String description; 
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_id")
	@JsonIgnore
    private JobSeeker jobSeeker;

}
