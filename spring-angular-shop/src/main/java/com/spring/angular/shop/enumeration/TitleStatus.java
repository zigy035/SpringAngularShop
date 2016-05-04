package com.spring.angular.shop.enumeration;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum TitleStatus {
	
	MR (0, "Mr."),
	MRS (1, "Mrs"),
	MS (2, "Ms"),
	MISS (3, "Miss"),
	DR (4, "Dr");
	
	private static final Map<Integer, TitleStatus> lookup = new HashMap<Integer, TitleStatus>();
	private static final Map<String, TitleStatus> lookupName = new HashMap<String, TitleStatus>();
	static
	{
		for (TitleStatus s : EnumSet.allOf(TitleStatus.class))
		{
			lookup.put(s.getCode(), s);
			lookupName.put(s.getName(), s);
		}
	}
	
	private int code;
	private String name;
	
	private TitleStatus(int code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getName() {
		return name;
	}
	
	
}
