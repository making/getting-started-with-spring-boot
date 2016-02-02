package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertyGreetingService implements GreetingService {
	@Value("${greeting.message}")
	String message;
	
	@Override
	public String greet() {
		return message;
	}

}
