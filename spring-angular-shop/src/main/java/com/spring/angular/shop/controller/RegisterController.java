package com.spring.angular.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.angular.shop.form.RegisterForm;
import com.spring.angular.shop.service.AuthenticationService;

@Controller
@RequestMapping(value = "/register")
public class RegisterController extends AbstractController
{
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	@Qualifier("customerValidator")
	private Validator customerValidator;
	
	@Autowired
	private ShaPasswordEncoder passwordEncoder;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegisterForm(Model model)
	{
		model.addAttribute("registerForm", new RegisterForm());
		model.addAttribute("titles", getTitles());

//		model.addAttribute("countries", CountryUtils.getCountries());
//		model.addAttribute("regions", CountryUtils.getRegions(null));
		
		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(Model model, RegisterForm registerForm, BindingResult result)
	{
		customerValidator.validate(registerForm, result);
		if (result.hasErrors())
		{
			model.addAttribute("registerForm", registerForm);
			model.addAttribute("titles", getTitles());
			return "register";
		}
		
/*		final AuthUser authUser = populateAuthUser(registerFormBean); 
		
		authUserService.addAuthUser(authUser);
		model.addAttribute("authUser", authUser);
*/		
		return "confirmRegister";
	}
	
	/*
	private AuthUser populateAuthUser(RegisterFormBean form) {
		AuthUser authUser = new AuthUser();
		authUser.setFirstName(form.getFirstName());
		authUser.setLastName(form.getLastName());
		authUser.setUsername(form.getUsername());
		authUser.setPassword(passwordEncoder.encodePassword(form.getPassword(), null));
		authUser.setAccess(0);
		return authUser;
	}*/
	
}
