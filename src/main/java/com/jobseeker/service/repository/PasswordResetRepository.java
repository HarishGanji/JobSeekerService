package com.jobseeker.service.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobseeker.service.model.PasswordRestOTP;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordRestOTP, UUID>{

	Optional<PasswordRestOTP> findFirstByEmailOrderByExpiryTimeDesc(String email);
	
	@Modifying
	@Query("DELETE FROM PasswordRestOTP p WHERE p.email = :email")
	void deleteByEmail(@Param("email") String email);

}
