package com.spring.angular.shop.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.spring.angular.shop.dao.AuthenticationDAO;
import com.spring.angular.shop.model.Customer;
import com.spring.angular.shop.service.AuthenticationService;



public class AuthenticationServiceImpl implements AuthenticationService
{
	protected static Logger LOG = Logger.getLogger(AuthenticationServiceImpl.class);
	
	private AuthenticationDAO authenticationDAO;
	private ShaPasswordEncoder passwordEncoder;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer dbUser = authenticationDAO.getAuthentication(username);
		
		if (dbUser == null)
		{
			LOG.info("User was not found!");
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
			LOG.info("Grant ROLE_ADMIN to this user");
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			// User has an ordinary user access
			LOG.info("Grant ROLE_USER to this user");
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		}

		return authList;
	}
	
	@Override
	public UsernamePasswordAuthenticationToken autoLogin(String username, String password) {
		
		UserDetails user;
		try {
	        user = loadUserByUsername(username);
	    } catch (Exception e) {
	    	user = null;
	    	LOG.error("Error loading user, not found: " + e.getMessage(), e);
	    }

	    if (user == null) {
	        throw new UsernameNotFoundException(String.format("Invalid credentials", username));
	    } else if (!user.isEnabled()) {
	        throw new UsernameNotFoundException(String.format("Not found enabled user for username ", username));
	    }
	    
	    //check user password stored in authentication.getCredentials() against stored password hash
	    String encodedPassword = passwordEncoder.encodePassword(password, null);
	    if (StringUtils.isBlank(password) || !encodedPassword.equals(user.getPassword())) {
	        throw new BadCredentialsException("Invalid credentials");
	    }
	    
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, encodedPassword, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(token);
//        LOG.info(String.format("Auto login %s successfully!", username));
		return token;
	}
	
	public Customer getAuthentication(String username) {
		return authenticationDAO.getAuthentication(username);
	}

	// Inject AuthUserDAO
	public void setAuthenticationDAO(AuthenticationDAO authenticationDAO) {
		this.authenticationDAO = authenticationDAO;
	}

	// Inject PasswordEncoder
	public void setPasswordEncoder(ShaPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}	

}
