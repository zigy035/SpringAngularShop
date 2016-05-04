package com.spring.angular.shop.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.angular.shop.model.Customer;

public interface AuthenticationService extends UserDetailsService {

	Customer getAuthentication(String username);
	
	void autoLogin(String username, String password);
	
}
