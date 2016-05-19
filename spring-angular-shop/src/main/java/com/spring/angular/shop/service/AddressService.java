package com.spring.angular.shop.service;

import java.util.List;

import com.spring.angular.shop.dto.AddressDTO;
import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;
import com.spring.angular.shop.model.Title;

public interface AddressService {
	
	List<Title> getTitles();
	
	List<Country> getCountries();
	
	List<Region> getRegions(String isoCode);
	
	Address getShippingAddress(String customerId);
	
	Address getBillingAddress(String customerId);

	AddressDTO getAddressDTO(String addressId);

	Address getAddress(String addressId);

	void updateAddress(Address address);
}
