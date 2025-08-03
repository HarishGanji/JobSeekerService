package com.jobseeker.service.serviceimplementation;

import java.time.LocalDateTime;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobseeker.service.exceptions.OTPException;
import com.jobseeker.service.model.PasswordRestOTP;
import com.jobseeker.service.repository.PasswordResetRepository;
import com.jobseeker.service.service.EmailService;
import com.jobseeker.service.service.OTPService;

import jakarta.transaction.Transactional;

@Service
public class OTPServiceImplementation implements OTPService {

	@Autowired
	private PasswordResetRepository otpRepo;

	@Autowired
	private EmailService emailService;

	private static final int OTP_EXPIRATION_MINUTES = 5;

	@Override
	@Transactional
	public String generateOTP(String email) {
	    try {
	        // Delete any existing OTP associated with the given email.
	        // This ensures only one valid OTP exists per email at a time.
	        otpRepo.deleteByEmail(email);

	        // Generate a random 6-digit OTP.
	        // Range: 100000 to 999999 (inclusive)
	        int otpNumber = new Random().nextInt(900000) + 100000;

	        // Convert the number to a String, as we usually store OTPs as Strings.
	        String otp = String.valueOf(otpNumber);

	        // Create a new PasswordRestOTP entity to store in the database.
	        PasswordRestOTP passwordResetOTP = new PasswordRestOTP();
	        passwordResetOTP.setEmail(email);  // Set the user's email
	        passwordResetOTP.setOtp(otp);      // Set the generated OTP

	        // Set the expiration time of the OTP (e.g., 5 minutes from now)
	        passwordResetOTP.setExpiryTime(LocalDateTime.now().plusMinutes(OTP_EXPIRATION_MINUTES));

	        // Save the OTP record to the database
	        otpRepo.save(passwordResetOTP);

	        // Send the OTP to the user's email address
	        emailService.sendEmail(email, "Password Reset OTP", "Your OTP is: " + otp);

	        // Return a success message
	        return "OTP sent to your email!";
	        
	    } catch (Exception ex) {
	        // If anything goes wrong (DB issue, email failure, etc.), throw a custom exception
	        throw new OTPException("Failed to generate OTP. " + ex.getMessage());
	    }
	}



	@Override
	public boolean verifyOTP(String email, String otp) {
		PasswordRestOTP storedOtp = otpRepo.findFirstByEmailOrderByExpiryTimeDesc(email)
			.orElseThrow(() -> new OTPException("No OTP found for this email."));
		if (!storedOtp.getOtp().equals(otp)) {
			throw new OTPException("Invalid OTP provided.");
		}
		if (storedOtp.getExpiryTime().isBefore(LocalDateTime.now())) {
			throw new OTPException("OTP has expired.");
		}
		otpRepo.delete(storedOtp); // OTP used and removed
		return true;
	}


}
