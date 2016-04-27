package com.spring.angular.shop.dao;

import java.util.List;

import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;

public interface AddressDAO {
	
	List<Country> getCountries();
	
	List<Region> getRegions(String isoCode);
}
