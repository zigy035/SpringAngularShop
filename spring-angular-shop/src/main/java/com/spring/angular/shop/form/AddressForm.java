package com.spring.angular.shop.form;

public class AddressForm {
	
	private String id;
	private String countryIso;
	private String regionIso;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCountryIso() {
		return countryIso;
	}
	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}
	public String getRegionIso() {
		return regionIso;
	}
	public void setRegionIso(String regionIso) {
		this.regionIso = regionIso;
	}
	
}
