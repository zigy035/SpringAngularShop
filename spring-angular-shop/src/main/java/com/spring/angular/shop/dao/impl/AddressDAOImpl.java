package com.spring.angular.shop.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.AddressDAO;
import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Country;
import com.spring.angular.shop.model.Region;
import com.spring.angular.shop.model.Title;

public class AddressDAOImpl extends SqlSessionDaoSupport implements AddressDAO {

	@Override
	public List<Title> getTitles() {
		return getSqlSession().selectList("getTitles");
	}
	
	@Override
	public List<Country> getCountries() {
		return getSqlSession().selectList("getCountries");
	}

	@Override
	public List<Region> getRegions(String isoCode) {
		return getSqlSession().selectList("getRegions", isoCode);
	}

	@Override
	public void addAddress(Address address) {
		getSqlSession().insert("addAddress", address);
	}

	@Override
	public Address getShippingAddress(String customerId) {
		return getSqlSession().selectOne("getShippingAddress", customerId);
	}

	@Override
	public Address getBillingAddress(String customerId) {
		return getSqlSession().selectOne("getBillingAddress", customerId);
	}

	@Override
	public Address getAddress(String addressId) {
		return getSqlSession().selectOne("getAddress", addressId);
	}

	@Override
	public void updateAddress(Address address) {
		getSqlSession().update("updateAddress", address);
	}

}
