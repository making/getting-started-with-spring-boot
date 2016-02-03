package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	List<City> getCities() {
		return jdbcTemplate.query("SELECT id, name FROM city ORDER BY id", (rs, i) -> {
			City city = new City();
			city.setId(rs.getInt("id"));
			city.setName(rs.getString("name"));
			return city;
		});
	}

	@RequestMapping(value = "/cities", method = RequestMethod.POST)
	City postCities(@RequestBody City city) {
		jdbcTemplate.update("INSERT INTO city(name) VALUES(?)", city.getName());
		return city;
	}
}
