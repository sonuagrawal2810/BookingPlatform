package com.demo.booking.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.booking.platform.entity.City;
import com.demo.booking.platform.entity.Movie;
import com.demo.booking.platform.service.CityService;
import com.demo.booking.platform.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {

	private final MovieService movieService;
	private final CityService cityService;

	@Autowired
	public MovieController(MovieService movieService, CityService cityService) {
		this.movieService = movieService;
		this.cityService = cityService;
	}

	@GetMapping("/movies")
	public List<Movie> getMoviesByCity(@RequestParam("city") String city) {
		return movieService.getMoviesByCity(city);
	}

	@GetMapping("/cities")
	public List<City> getCities() {
		return cityService.findAll();
	}

}
