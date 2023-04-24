package com.demo.booking.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.booking.platform.entity.Theater;
import com.demo.booking.platform.service.TheaterService;

@RestController
@RequestMapping("/theaters")
public class TheaterController {
	private final TheaterService theaterService;

	@Autowired
	public TheaterController(TheaterService theaterService) {
		this.theaterService = theaterService;
	}

	@GetMapping("/{city}/movies/{movieName}")
	public List<Theater> getTheatersByCityAndMovieName(@PathVariable String city, @PathVariable String movieName) {
		return theaterService.getTheatersByCityAndMovieName(city, movieName);
	}

}
