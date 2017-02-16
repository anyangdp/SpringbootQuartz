package com.sq.domain;

import lombok.Data;

@Data
public class Hello {
	public Hello(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Hello() {
		super();
	}

	private String name;
	
	private String age;
}
