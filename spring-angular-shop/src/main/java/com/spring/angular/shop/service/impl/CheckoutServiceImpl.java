package com.spring.angular.shop.service.impl;

import java.util.List;

import com.spring.angular.shop.dao.CheckoutDAO;
import com.spring.angular.shop.dto.CartDTO;
import com.spring.angular.shop.model.DeliveryType;
import com.spring.angular.shop.model.PaymentMethod;
import com.spring.angular.shop.service.CheckoutService;

public class CheckoutServiceImpl implements CheckoutService {
	
	private CheckoutDAO checkoutDAO;
	
	@Override
	public List<DeliveryType> getDeliveryTypes() {
		return checkoutDAO.getDeliveryTypes();
	}

	@Override
	public List<PaymentMethod> getPaymentMethods() {
		return checkoutDAO.getPaymentMethods();
	}
	
	@Override
	public CartDTO getCheckoutCartData() {
		// TODO Auto-generated method stub
		return null;
	}

	// Inject DAO
	public void setCheckoutDAO(CheckoutDAO checkoutDAO) {
		this.checkoutDAO = checkoutDAO;
	}

}
