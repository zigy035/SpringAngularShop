package com.spring.angular.shop.form;

public class AddressForm {
	
	private String id;
	
	private String addressLine;
	private Boolean addressLineError;
	
	private String countryIso;
	private String regionIso;
	
	private String city;
//	private String cityError;

	private String postcode;
	private String phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	
	public Boolean getAddressLineError() {
		return addressLineError;
	}
	public void setAddressLineError(Boolean addressLineError) {
		this.addressLineError = addressLineError;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
