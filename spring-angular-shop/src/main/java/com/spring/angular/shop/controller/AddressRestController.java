package com.spring.angular.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
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
@RequestMapping("/address-rest")
public class AddressRestController {
	
	@Autowired
	private AddressService addressService; 
	
	@RequestMapping(value = "/titles", method = RequestMethod.GET)
	@ResponseBody
	public List<Title> loadTitles() {
		return addressService.getTitles();
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	@ResponseBody
	public List<Country> loadCountries() {
		
		List<Country> countries = addressService.getCountries();
        if (CollectionUtils.isEmpty(countries)) {
            return new ArrayList<Country>();
        }
        return countries;
	}
	
	@RequestMapping(value = "/regions/{isoCode}", method = RequestMethod.GET)
	@ResponseBody
	public List<Region> loadRegions(@PathVariable("isoCode") String isoCode) {
		
		List<Region> regions = addressService.getRegions(isoCode);
        if (CollectionUtils.isEmpty(regions)) {
            return new ArrayList<Region>();
        }
        return regions;
	}
	
}
