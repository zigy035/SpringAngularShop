package com.spring.angular.shop.dao.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.TaxDAO;
import com.spring.angular.shop.model.Tax;

public class TaxDAOImpl extends SqlSessionDaoSupport implements TaxDAO {

	@Override
	public Tax getTax(String regionCode) {
		return getSqlSession().selectOne("getTax", regionCode);
	}

}
