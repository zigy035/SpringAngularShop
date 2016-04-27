package com.spring.angular.shop.service;

import java.util.List;

import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;

public interface AddressService {
	
	List<Country> getCountries();
	
	List<Region> getRegions(String isoCode);
}
