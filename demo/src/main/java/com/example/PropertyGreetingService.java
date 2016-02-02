package com.example;

import org.springframework.beans.factory.annotation.Value;

public class PropertyGreetingService implements GreetingService {
	@Value("${greeting.message}")
	String message;
	
	@Override
	public String greet() {
		return message;
	}

}
