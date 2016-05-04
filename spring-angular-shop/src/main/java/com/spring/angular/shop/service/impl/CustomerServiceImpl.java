package com.spring.angular.shop.service.impl;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.spring.angular.shop.dao.AddressDAO;
import com.spring.angular.shop.dao.CustomerDAO;
import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Customer;
import com.spring.angular.shop.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDAO customerDAO; 
	
	private AddressDAO addressDAO;
	
	private ShaPasswordEncoder passwordEncoder;
	
	@Override
	public void registerCustomer(Customer customer, Address shippingAddress, Address billingAddress) {
		customer.setPassword(passwordEncoder.encodePassword(customer.getPassword(), null));
		customerDAO.addCustomer(customer);
		addressDAO.addAddress(shippingAddress);
		addressDAO.addAddress(billingAddress);
	}

	// Inject DAO
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	// Inject DAO
	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	// Inject Password encoder
	public void setPasswordEncoder(ShaPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	
}
