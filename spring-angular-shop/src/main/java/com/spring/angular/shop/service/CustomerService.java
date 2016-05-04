package com.spring.angular.shop.service;

import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Customer;

public interface CustomerService {
	
	void registerCustomer(Customer customer, Address shippingAddress, Address billingAddress);
}
