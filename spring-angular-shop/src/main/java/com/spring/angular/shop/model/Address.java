package com.spring.angular.shop.model;

import com.spring.angular.shop.util.KeyGenerator;

public class Address {
	
	private String id;
	private String customerId;
	private String title;
	private String firstName;
	private String lastName;
	private String addressLine;
	private String countryIso;
	private String countryLocName;
	private String regionIso;
	private String regionLocName;
	private String province;
	private String city;
	private String postcode;
	private String phone;	
	private Boolean contactAddress;
	private Boolean billingAddress;
	private Boolean shippingAddress;
	
	public Address() {
		this.id = KeyGenerator.generate();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCountryIso() {
		return countryIso;
	}
	public void setCountryIso(String countryIso) {
		this.countryIso = countryIso;
	}
	public String getCountryLocName() {
		return countryLocName;
	}
	public void setCountryLocName(String countryLocName) {
		this.countryLocName = countryLocName;
	}
	public String getRegionIso() {
		return regionIso;
	}
	public void setRegionIso(String regionIso) {
		this.regionIso = regionIso;
	}
	public String getRegionLocName() {
		return regionLocName;
	}
	public void setRegionLocName(String regionLocName) {
		this.regionLocName = regionLocName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
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
	public Boolean getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(Boolean contactAddress) {
		this.contactAddress = contactAddress;
	}
	public Boolean getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Boolean billingAddress) {
		this.billingAddress = billingAddress;
	}
	public Boolean getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Boolean shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
}
