package com.spring.angular.shop.enumeration;

public enum TitleStatus {
	
	MR (0, "Mr."),
	MRS (1, "Mrs"),
	MS (2, "Ms"),
	MISS (3, "Miss"),
	DR (4, "Dr");
	
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
