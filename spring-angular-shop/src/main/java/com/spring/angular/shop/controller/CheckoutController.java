package com.spring.angular.shop.controller;

import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.angular.shop.dto.AddressDTO;
import com.spring.angular.shop.dto.CartDTO;
import com.spring.angular.shop.form.CheckoutForm;
import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.service.AddressService;
import com.spring.angular.shop.service.CartService;
import com.spring.angular.shop.service.CheckoutService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController extends AbstractController {
	
	private static final Logger LOG = Logger.getLogger(CheckoutController.class);
	
	private static final String REGION_DELIMITER = "-";
	public static final String COUNTRY_KEY_PATTERN = "country.%s";
	public static final String REGION_KEY_PATTERN = "region.%s.%s";
	private static final String DEFAULT_DELIVERY_TYPE = "default.delivery.type";
	private static final String DEFAULT_PAYMENT_METHOD = "default.payment.method";
	
	@Autowired
	private AddressService addressService; 
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CheckoutService checkoutService;
	
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showCheckoutPage(Model model) {
		
		//check if delivery type and payment method are set.
		CartDTO cartData = cartService.getCartData(getAuthUser().getId());
		CheckoutForm checkoutForm = new CheckoutForm();
		
		Locale locale = LocaleContextHolder.getLocale();
		if (StringUtils.isEmpty(cartData.getDeliveryType())) {
			checkoutForm.setDeliveryType(messageSource.getMessage(DEFAULT_DELIVERY_TYPE, null, locale));
		} else {
			checkoutForm.setDeliveryType(cartData.getDeliveryType());
		}

		if (StringUtils.isEmpty(cartData.getPaymentMethod())) {
			checkoutForm.setPaymentMethod(messageSource.getMessage(DEFAULT_PAYMENT_METHOD, null, locale));
		} else {
			checkoutForm.setPaymentMethod(cartData.getPaymentMethod());
		}

		model.addAttribute("checkoutForm", checkoutForm);
		model.addAttribute("deliveryTypes", checkoutService.getDeliveryTypes());
		model.addAttribute("paymentMethods", checkoutService.getPaymentMethods());
		
		return "checkout";
	}
	
	@RequestMapping(value = "/rest/cart", method = RequestMethod.GET)
	@ResponseBody
	public CartDTO getCartData(Model model) {
		if (getAuthUser() == null) {
			return null;
		}
		return cartService.getCartData(getAuthUser().getId());
	}
	
	@RequestMapping(value = "/rest/update-delivery-cost/{deliveryType}", method = RequestMethod.GET)
	@ResponseBody
	public CartDTO updateDeliveryCost(Model model, @PathVariable("deliveryType") String deliveryType) {
		if (getAuthUser() == null) {
			return null;
		}
		CartDTO cartDTO = cartService.getCheckoutCartData(getAuthUser().getId(), deliveryType);
		
		return cartDTO;
	}
	
	@RequestMapping(value = "/rest/edit-address/{addressId}", method = RequestMethod.GET)
	@ResponseBody
	public AddressDTO getBillingAddress(Model model, @PathVariable("addressId") String addressId) {
		if (getAuthUser() == null) {
			return null;
		}
		return addressService.getAddressDTO(addressId);
	}
	
	@RequestMapping(value = "/rest/update-address", method = RequestMethod.POST)
	@ResponseBody
	public Address updateBillingAddress(Model model, @RequestBody Address address, BindingResult result) {
		
		LOG.info("Address Line: " + address.getAddressLine());
		
		addressService.updateAddress(address);
		Address updatedAddress = addressService.getAddress(address.getId());
		setI18ToAddress(updatedAddress);
		
		return updatedAddress;
	}
	
	@RequestMapping(value = "/rest/billing-address", method = RequestMethod.GET)
	@ResponseBody
	public Address getBillingAddress(Model model) {
		if (getAuthUser() == null) {
			return null;
		}
		Address address = addressService.getBillingAddress(getAuthUser().getId());
		setI18ToAddress(address);
		return address;
	}

	@RequestMapping(value = "/rest/shipping-address", method = RequestMethod.GET)
	@ResponseBody
	public Address getShippingAddress(Model model) {
		if (getAuthUser() == null) {
			return null;
		}		
		Address address = addressService.getShippingAddress(getAuthUser().getId());
		setI18ToAddress(address);
		return address;
	}
	
	private void setI18ToAddress(Address address) {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		String countryIso = address.getCountryIso().toLowerCase();
		String regionIso = address.getRegionIso().toLowerCase();
		String [] regionParts = regionIso.split(REGION_DELIMITER);
		
		String countryKey = String.format(COUNTRY_KEY_PATTERN, countryIso);
		String regionKey = String.format(REGION_KEY_PATTERN, regionParts[0], regionParts[1]);
		
		address.setCountryLocName(messageSource.getMessage(countryKey, null, locale));
		address.setRegionLocName(messageSource.getMessage(regionKey, null, locale));
	}
	
}
