package com.spring.angular.shop.dto;

import java.util.List;

import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;

public class AddressDTO {
	
	private Address address;
	private List<Country> countries;
	private List<Region> regions;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public List<Country> getCountries() {
		return countries;
	}
	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	
}
