package com.jobseeker.service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobseeker.service.model.JobSeeker;

@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, UUID> {

	Optional<JobSeeker> findByEmail(String email);

	@Query("SELECT j FROM JobSeeker j WHERE j.id = :JobSeekerId")
	JobSeeker getJobSeekerById(@Param("JobSeekerId") UUID id);

}
