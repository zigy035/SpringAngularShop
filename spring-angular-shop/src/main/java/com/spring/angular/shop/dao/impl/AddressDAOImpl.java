package com.spring.angular.shop.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.AddressDAO;
import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;

public class AddressDAOImpl extends SqlSessionDaoSupport implements AddressDAO {

	@Override
	public List<Country> getCountries() {
		return getSqlSession().selectList("getCountries");
	}

	@Override
	public List<Region> getRegions(String isoCode) {
		return getSqlSession().selectList("getRegions", isoCode);
	}

	
}
