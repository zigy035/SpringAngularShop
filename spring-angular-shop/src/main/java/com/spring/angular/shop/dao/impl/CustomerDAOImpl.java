package com.spring.angular.shop.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.CustomerDAO;
import com.spring.angular.shop.model.Customer;

public class CustomerDAOImpl extends SqlSessionDaoSupport implements CustomerDAO {

	@Override
	public void addCustomer(Customer customer) {
		getSqlSession().insert("addCustomer", customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return getSqlSession().selectOne("getCustomerByEmail", email);
	}

}
