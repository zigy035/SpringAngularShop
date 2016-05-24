package com.spring.angular.shop.model;

import java.util.Calendar;
import java.util.Date;

import com.spring.angular.shop.util.KeyGenerator;

public class Cart {

	private String id;
	private String customerId;
	private String deliveryTypeCode;
	private String paymentMethodCode;
	private Date created;
	
	public Cart() {}
	
	public Cart(String customerId) {
		this.id = KeyGenerator.generate();
		this.customerId = customerId;
		this.created = Calendar.getInstance().getTime();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getDeliveryTypeCode() {
		return deliveryTypeCode;
	}

	public void setDeliveryTypeCode(String deliveryTypeCode) {
		this.deliveryTypeCode = deliveryTypeCode;
	}

	public String getPaymentMethodCode() {
		return paymentMethodCode;
	}

	public void setPaymentMethodCode(String paymentMethodCode) {
		this.paymentMethodCode = paymentMethodCode;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
}
