package com.jobseeker.service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobseeker.service.model.Experience;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, UUID>{

}
