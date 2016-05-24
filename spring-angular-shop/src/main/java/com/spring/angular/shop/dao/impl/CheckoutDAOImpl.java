package com.spring.angular.shop.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.spring.angular.shop.dao.CheckoutDAO;
import com.spring.angular.shop.model.DeliveryType;
import com.spring.angular.shop.model.PaymentMethod;

public class CheckoutDAOImpl extends SqlSessionDaoSupport implements CheckoutDAO {

	@Override
	public List<DeliveryType> getDeliveryTypes() {
		return getSqlSession().selectList("getDeliveryTypes");
	}

	@Override
	public DeliveryType getDeliveryType(String code) {
		return getSqlSession().selectOne("getDeliveryType", code);
	}

	@Override
	public List<PaymentMethod> getPaymentMethods() {
		return getSqlSession().selectList("getPaymentMethods");
	}

	@Override
	public PaymentMethod getPaymentMethod(String code) {
		return getSqlSession().selectOne("getPaymentMethod", code);
	}

}
