package com.spring.angular.shop.service.impl;

import java.util.List;

import com.spring.angular.shop.dao.AddressDAO;
import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;
import com.spring.angular.shop.model.Title;
import com.spring.angular.shop.service.AddressService;

public class AddressServiceImpl implements AddressService {

	private AddressDAO addressDAO;
	
	@Override
	public List<Title> getTitles() {
		return addressDAO.getTitles();
	}
	
	@Override
	public List<Country> getCountries() {
		return addressDAO.getCountries();
	}

	@Override
	public List<Region> getRegions(String isoCode) {
		return addressDAO.getRegions(isoCode);
	}

	// Inject DAO
	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

}
