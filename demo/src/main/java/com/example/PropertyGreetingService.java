package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PropertyGreetingService implements GreetingService {
	@Value("${greeting.message}")
	String message;
	
	@Override
	public String greet() {
		return message;
	}

}
