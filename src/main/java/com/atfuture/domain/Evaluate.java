package com.atfuture.domain;

public enum Evaluate {
	EXCELLENT("优","30"),GOOD("良","20"), MEDIUM("中","10"), POOR("差","0");
	private   final String name;
	private   final String value;
	private Evaluate(String name,String value) {
		this.name=name;
		this.value=value;
	}
	public String getName() {
		return name;
	}
	public String getValue() {
		return value;
	}
	
	
}
