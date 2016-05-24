package com.spring.angular.shop.service;

import java.util.List;

import com.spring.angular.shop.dto.CartDTO;
import com.spring.angular.shop.model.DeliveryType;
import com.spring.angular.shop.model.PaymentMethod;

public interface CheckoutService {
	
	List<DeliveryType> getDeliveryTypes();
	
	List<PaymentMethod> getPaymentMethods();
	
	CartDTO getCheckoutCartData();
}
