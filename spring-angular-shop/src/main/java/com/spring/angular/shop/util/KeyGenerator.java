package com.spring.angular.shop.util;

import java.util.UUID;

public class KeyGenerator {

	public static String generate() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
