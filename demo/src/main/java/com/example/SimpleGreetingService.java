package com.example;

public class SimpleGreetingService implements GreetingService {

	@Override
	public String greet() {
		return "Hello World!";
	}

}
