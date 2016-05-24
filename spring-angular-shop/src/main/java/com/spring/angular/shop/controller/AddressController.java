package com.spring.angular.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;
import com.spring.angular.shop.model.Title;
import com.spring.angular.shop.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService; 
	
	@RequestMapping(value = "/rest/titles", method = RequestMethod.GET)
	@ResponseBody
	public List<Title> loadTitles() {
		return addressService.getTitles();
	}
	
	@RequestMapping(value = "/rest/countries", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> loadCountries() {
        return addressService.getCountries();
	}
	
	@RequestMapping(value = "/rest/regions/{isoCode}", method = RequestMethod.GET)
	@ResponseBody
	public List<Region> loadRegions(@PathVariable("isoCode") String isoCode) {
        return addressService.getRegions(isoCode);
	}
	
}
