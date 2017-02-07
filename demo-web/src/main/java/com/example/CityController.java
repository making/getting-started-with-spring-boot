package com.example;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	static List<City> cities = new CopyOnWriteArrayList<>();
	static AtomicInteger counter = new AtomicInteger(0);

	@GetMapping("/cities")
	List<City> getCities() {
		return cities;
	}

	@PostMapping("/cities")
	City postCities(@RequestBody City city) {
		city.setId(counter.incrementAndGet());
		cities.add(city);
		return city;
	}
}
