package com.example;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	static List<City> cities = new CopyOnWriteArrayList<>();
	static AtomicInteger counter = new AtomicInteger(0);

	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	List<City> getCities() {
		return cities;
	}

	@RequestMapping(value = "/cities", method = RequestMethod.POST)
	City postCities(@RequestBody City city) {
		city.setId(counter.incrementAndGet());
		cities.add(city);
		return city;
	}
}
