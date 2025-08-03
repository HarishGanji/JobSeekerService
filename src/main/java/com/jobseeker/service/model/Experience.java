package com.jobseeker.service.model;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

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

    private LocalDate startDate; // From
    private LocalDate endDate;   // To — can be null if currently working

    private boolean currentlyWorking; // true if currently working

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobseeker_id")
    @JsonIgnore
    private JobSeeker jobSeeker;
}
