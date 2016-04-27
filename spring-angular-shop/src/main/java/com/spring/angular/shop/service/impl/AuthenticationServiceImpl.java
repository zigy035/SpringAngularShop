package com.spring.angular.shop.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.angular.shop.dao.AuthenticationDAO;
import com.spring.angular.shop.model.Customer;
import com.spring.angular.shop.service.AuthenticationService;



public class AuthenticationServiceImpl implements AuthenticationService
{
	protected static Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);
	
	private AuthenticationDAO authenticationDAO;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer dbUser = authenticationDAO.getAuthentication(username);
		
		if (dbUser == null)
		{
			logger.debug("User was not found!");
			throw new UsernameNotFoundException("User not found");			
		}
		
		int access = dbUser.getAccess();		
		UserDetails user = new org.springframework.security.core.userdetails.User(
				dbUser.getEmail(), dbUser.getPassword(), 
				true, true, true, true, getAuthorities(access));
		
		return user;
	}

	public Collection<GrantedAuthority> getAuthorities(Integer access)
	{
		// Create a list of grants for this user
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

		// Check if this user has admin access
		if (access.compareTo(1) == 0) {
			// User has admin access
			logger.debug("Grant ROLE_ADMIN to this user");
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			// User has an ordinary user access
			logger.debug("Grant ROLE_USER to this user");
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}

		return authList;
	}
	
	public Customer getAuthentication(String username) {
		return authenticationDAO.getAuthentication(username);
	}

	public void addCustomer(Customer customer) {
		authenticationDAO.addCustomer(customer);
	}

	// Inject AuthUserDAO
	public void setAuthenticationDAO(AuthenticationDAO authenticationDAO) {
		this.authenticationDAO = authenticationDAO;
	}
	

}
