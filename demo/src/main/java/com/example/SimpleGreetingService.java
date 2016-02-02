package com.example;

import org.springframework.stereotype.Component;

@Component
public class SimpleGreetingService implements GreetingService {

	@Override
	public String greet() {
		return "Hello World!";
	}

}
