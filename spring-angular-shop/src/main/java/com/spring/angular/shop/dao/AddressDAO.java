package com.spring.angular.shop.dao;

import java.util.List;

import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;
import com.spring.angular.shop.model.Title;

public interface AddressDAO {
	
	List<Title> getTitles();
	
	List<Country> getCountries();
	
	List<Region> getRegions(String isoCode);
	
	void addAddress(Address address);

	Address getShippingAddress(String customerId);
}
