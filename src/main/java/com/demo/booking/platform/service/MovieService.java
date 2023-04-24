package com.demo.booking.platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.booking.platform.entity.Movie;
import com.demo.booking.platform.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<Movie> getMoviesByCity(String cityName) {
		return movieRepository.findByCitiesName(cityName);
	}
}
