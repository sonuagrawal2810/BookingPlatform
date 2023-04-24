package com.demo.booking.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.booking.platform.entity.Theater;

import com.demo.booking.platform.repository.TheaterRepository;

@Service
public class TheaterService {
	private final TheaterRepository theaterRepository;

	@Autowired
	public TheaterService(TheaterRepository theaterRepository) {
		this.theaterRepository = theaterRepository;
	}

	public List<Theater> getTheatersByCityAndMovieName(String city, String movieName) {
		return theaterRepository.findByCityAndMovieName(city, movieName);
	}

}
