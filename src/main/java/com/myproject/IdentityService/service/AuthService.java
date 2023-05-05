package com.myproject.IdentityService.service;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.IdentityService.Entity.UserCredential;
import com.myproject.IdentityService.repository.UserCredentialRepository;

@Service
public class AuthService {

	@Autowired
	private UserCredentialRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	public String saveUser(UserCredential credential)
	{
		credential.setPassword(passwordEncoder.encode(credential.getPassword()));
		repository.save(credential);
		return "sign up successsful";
	}
	
	public String generateToken(String username)
	{
		return jwtService.generateToken(username);
	}
	
	public void validateToken(String token)
	{
		jwtService.validateToken(token);
	}
}
