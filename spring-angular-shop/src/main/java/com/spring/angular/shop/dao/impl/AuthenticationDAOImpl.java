package com.spring.angular.shop.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.AuthenticationDAO;
import com.spring.angular.shop.model.Customer;

public class AuthenticationDAOImpl extends SqlSessionDaoSupport implements AuthenticationDAO {

	public Customer getAuthentication(String username) {
		Customer authUser = (Customer) getSqlSession().selectOne("getCustomerByEmail", username);
		return authUser;
	}

	public void addCustomer(Customer customer) {
		getSqlSession().insert("addCustomer", customer);
	}

}
