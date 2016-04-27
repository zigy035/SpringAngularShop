package com.spring.angular.shop.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.spring.angular.shop.enumeration.TitleStatus;
import com.spring.angular.shop.model.Customer;
import com.spring.angular.shop.service.AuthenticationService;

public abstract class AbstractController {
	
	@Autowired
	protected AuthenticationService authenticationService;
		
	protected List<String> getBroadcastDateStrings() {
		List<String> availableDates = new ArrayList<String>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		for (int i=0; i<7; i++) {
			availableDates.add(dateFormat.format(cal.getTime()));
			cal.add(Calendar.DATE, 1);
		}
		return availableDates;
	}
	
	protected List<Date> getBroadcastDates() {
		List<Date> availableDates = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		for (int i=0; i<7; i++) {
			availableDates.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		return availableDates;
	}
	
	protected List<String> getBroadcastHours() {
		List<String> hours = new ArrayList<String>();
		for (int i=12; i<24; i++) {
			String strHour = (i<10) ? String.valueOf("0" + i) : String.valueOf(i);
			hours.add(strHour);
		}
		return hours;
	}
	
	protected List<String> getBroadcastMinutes() {
		String [] minutes = {"00", "15", "30", "45"};
		return Arrays.asList(minutes);
	}
	
	protected Customer getAuthUser()
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); //get logged in username
	    return authenticationService.getAuthentication(username);
	}
	
	protected List<TitleStatus> getTitles() {
		return Arrays.asList(TitleStatus.values());
	}
	
}
