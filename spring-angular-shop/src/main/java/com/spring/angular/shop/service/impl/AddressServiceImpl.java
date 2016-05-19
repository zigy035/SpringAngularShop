package com.spring.angular.shop.service.impl;

import java.util.List;

import com.spring.angular.shop.dao.AddressDAO;
import com.spring.angular.shop.dto.AddressDTO;
import com.spring.angular.shop.model.Address;
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

	@Override
	public Address getShippingAddress(String customerId) {
		return addressDAO.getShippingAddress(customerId);
	}
	
	@Override
	public Address getBillingAddress(String customerId) {
		return addressDAO.getBillingAddress(customerId);
	}
	
	@Override
	public AddressDTO getAddressDTO(String addressId) {
		Address address = addressDAO.getAddress(addressId);
		List<Country> countries = addressDAO.getCountries();
		List<Region> regions = addressDAO.getRegions(address.getCountryIso());
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setAddress(address);
		addressDTO.setCountries(countries);
		addressDTO.setRegions(regions);
		return addressDTO;
	}
	
	// Inject DAO
	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	@Override
	public Address getAddress(String addressId) {
		return addressDAO.getAddress(addressId);
	}

	@Override
	public void updateAddress(Address address) {
		addressDAO.updateAddress(address);
	}

}
