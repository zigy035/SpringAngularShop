package com.spring.angular.shop.dao;

import com.spring.angular.shop.model.Customer;

public interface CustomerDAO {
	
	void addCustomer(Customer customer);
	
	Customer getCustomerByEmail(String email);
}
