package com.spring.angular.shop.service;

import java.util.List;

import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;
import com.spring.angular.shop.model.Title;

public interface AddressService {
	
	List<Title> getTitles();
	
	List<Country> getCountries();
	
	List<Region> getRegions(String isoCode);
	
}
