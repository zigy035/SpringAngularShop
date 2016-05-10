package com.spring.angular.shop.dao;

import com.spring.angular.shop.model.Tax;

public interface TaxDAO {
	
	Tax getTax(String regionCode);
}
