package com.spring.angular.shop.form;

public class CheckoutForm {
	
	public CheckoutForm() {
		this.deliveryType = "STANDARD";
		this.paymentMethod = "CREDIT_CARD";
	}
	
	/*STANDARD, NEXT_DAY*/
	private String deliveryType;

	/*CREDIT_CARD, PAYPAL, CYBERSOURCE*/
	private String paymentMethod;
	
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
}
