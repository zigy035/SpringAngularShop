package com.spring.angular.shop.dao;

import java.util.List;

import com.spring.angular.shop.model.DeliveryType;
import com.spring.angular.shop.model.PaymentMethod;

public interface CheckoutDAO {
	
	List<DeliveryType> getDeliveryTypes();
	
	DeliveryType getDeliveryType(String code);

	List<PaymentMethod> getPaymentMethods();

	PaymentMethod getPaymentMethod(String code);
}
