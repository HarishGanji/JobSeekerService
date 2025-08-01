package com.jobseeker.service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobseeker.service.model.Education;

@Repository
public interface EducationRepository extends JpaRepository<Education, UUID>{

}
