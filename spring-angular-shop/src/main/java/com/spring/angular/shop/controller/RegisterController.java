package com.spring.angular.shop.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.angular.shop.form.RegisterForm;
import com.spring.angular.shop.model.Address;
import com.spring.angular.shop.model.Customer;
import com.spring.angular.shop.service.AuthenticationService;
import com.spring.angular.shop.service.CustomerService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController extends AbstractController
{
	private static final Logger LOG = Logger.getLogger(RegisterController.class);
	private static final String ANGULAR_DELIMITER = ":";
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator customerValidator;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegisterForm(Model model)
	{
		model.addAttribute("registerForm", new RegisterForm());		
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(Model model, RegisterForm form, BindingResult result)
	{
		customerValidator.validate(form, result);
		if (result.hasErrors())
		{
			model.addAttribute("registerForm", form);
			return "register";
		}
		LOG.info("Title:" + form.getTitle());
		LOG.info("Shipping Country:" + form.getShippingCountry());
		LOG.info("Shipping Region:" + form.getShippingRegion());

		Customer customer = populateCustomer(form);
		Address shippingAddress = populateShippingAddress(form, customer.getId());
		Address billingAddress = populateBillingAddress(form, customer.getId());
		
		customerService.registerCustomer(customer, shippingAddress, billingAddress);
		authenticationService.autoLogin(form.getEmail(), form.getPassword());
		
		model.addAttribute("customer", customer);
		
		return "confirmRegister";
	}
	
	
	private Customer populateCustomer(RegisterForm form) {
		Customer customer = new Customer();
		customer.setTitle(filterAngularValue(form.getTitle()));
		customer.setFirstName(form.getFirstName());
		customer.setLastName(form.getLastName());
		customer.setEmail(form.getEmail());
		customer.setPassword(form.getPassword());
		customer.setAccess(0);
		return customer;
	}
	
	private Address populateCommonAddressData(RegisterForm form, String customerId) {
		Address address = new Address();
		address.setCustomerId(customerId);
		address.setTitle(form.getTitle());
		address.setFirstName(form.getFirstName());
		address.setLastName(form.getLastName());
		return address;
	}
	
	private Address populateShippingAddress(RegisterForm form, String customerId) {
		Address address = populateCommonAddressData(form, customerId);
		address.setAddressLine(form.getShippingAddressLine());
		String countryIso = filterAngularValue(form.getShippingCountry());
		address.setCountryIso(countryIso);
		if ("CA".equals(countryIso) || "US".equals(countryIso)) {
			address.setRegionIso(filterAngularValue(form.getShippingRegion()));
			address.setProvince(null);
		} else {
			address.setRegionIso(null);
			address.setProvince(form.getShippingProvince());
		}
		address.setCity(form.getShippingCity());
		address.setPostcode(form.getShippingPostcode());
		address.setPhone(form.getShippingPhone());
		
		address.setShippingAddress(true);
		address.setContactAddress(false);
		address.setBillingAddress(false);
		
		return address;
	}
	
	private Address populateBillingAddress(RegisterForm form, String customerId) {
		Address address = populateCommonAddressData(form, customerId);
		address.setAddressLine(form.getBillingAddressLine());
		String countryIso = filterAngularValue(form.getBillingCountry());
		address.setCountryIso(countryIso);
		if ("CA".equals(countryIso) || "US".equals(countryIso)) {
			address.setRegionIso(filterAngularValue(form.getBillingRegion()));
			address.setProvince(null);
		} else {
			address.setRegionIso(null);
			address.setProvince(form.getBillingProvince());
		}
		address.setCity(form.getBillingCity());
		address.setPostcode(form.getBillingPostcode());
		address.setPhone(form.getBillingPhone());
		
		address.setShippingAddress(false);
		address.setContactAddress(false);
		address.setBillingAddress(true);
		
		return address;
	}

	// Title, Countries and Regions
	private String filterAngularValue(String angValue) {
		
		if (StringUtils.isBlank(angValue)) {
			return null;
		}
		
		if (angValue.contains(ANGULAR_DELIMITER)) {
			LOG.info("Ang Value: " + angValue);
 			String [] parts = angValue.split(ANGULAR_DELIMITER);
			return parts[1];
		}
		return angValue;
	}
	
}
