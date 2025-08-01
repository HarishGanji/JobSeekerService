package com.jobseeker.service.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = 1L;

    private final JobSeeker jobSeeker;

    public CustomUserDetails(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; // implement roles if needed
    }

    @Override
    public String getPassword() {
        return jobSeeker.getPassword();
    }

    @Override
    public String getUsername() {
        return jobSeeker.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
