package com.spring.angular.shop.validator;

import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.spring.angular.shop.dao.CustomerDAO;
import com.spring.angular.shop.form.RegisterForm;

public class CustomerValidator implements Validator {
	
	private CustomerDAO customerDAO;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterForm.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {
		RegisterForm form = (RegisterForm) object;
		
		/*		
 		if (StringUtils.isBlank(form.getTitle())) {
			errors.rejectValue("title", "title.required");
		}
		*/		
		if (StringUtils.isBlank(form.getFirstName())) {
			errors.rejectValue("firstName", "firstname.required");
		}
		if (StringUtils.isBlank(form.getLastName())) {
			errors.rejectValue("lastName", "lastname.required");
		}
		if (StringUtils.isBlank(form.getEmail())) {
			errors.rejectValue("email", "email.required");
		} else if (customerDAO.getCustomerByEmail(form.getEmail()) != null) {
			errors.rejectValue("email", "email.exist");
		}
		if (StringUtils.isBlank(form.getPassword())) {
			errors.rejectValue("password", "password.required");
		}
		if (StringUtils.isBlank(form.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmpassword.required");
		}
		if (StringUtils.isNotBlank(form.getPassword()) && StringUtils.isNotBlank(form.getConfirmPassword()) &&
				!form.getPassword().equals(form.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "confirmpassword.invalid");
		}
		
		if (StringUtils.isBlank(form.getShippingAddressLine())) {
			errors.rejectValue("shippingAddressLine", "shipping.addressline.required");
		}
		if (StringUtils.isBlank(form.getShippingCountry())) {
			errors.rejectValue("shippingCountry", "shipping.country.required");
		}
		if (StringUtils.isBlank(form.getShippingCity())) {
			errors.rejectValue("shippingCity", "shipping.city.required");
		}
		if (StringUtils.isBlank(form.getShippingPostcode())) {
			errors.rejectValue("shippingPostcode", "shipping.postcode.required");
		}
		
		if (StringUtils.isBlank(form.getBillingAddressLine())) {
			errors.rejectValue("billingAddressLine", "billing.addressline.required");
		}
		if (StringUtils.isBlank(form.getBillingCountry())) {
			errors.rejectValue("billingCountry", "billing.country.required");
		}
		if (StringUtils.isBlank(form.getBillingCity())) {
			errors.rejectValue("billingCity", "billing.city.required");
		}
		if (StringUtils.isBlank(form.getBillingPostcode())) {
			errors.rejectValue("billingPostcode", "billing.postcode.required");
		}
		
		if (!Boolean.TRUE.equals(form.getAcceptTerms())) {
			errors.rejectValue("acceptTerms", "billing.acceptterms.required");
		}
		
	}

	// Inject CustomerDAO
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
