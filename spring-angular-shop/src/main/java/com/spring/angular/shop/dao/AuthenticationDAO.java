package com.spring.angular.shop.dao;

import com.spring.angular.shop.model.Customer;

public interface AuthenticationDAO 
{
	public Customer getAuthentication(String username);
	
//	public void addCustomer(Customer customer);
	
}
