package com.demo.booking.platform.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.booking.platform.entity.MovieTicket;
import com.demo.booking.platform.repository.MovieTicketRepository;

@Service
public class MovieTicketService {

	private final MovieTicketRepository movieTicketRepository;

	public MovieTicketService(MovieTicketRepository movieTicketRepository) {
		this.movieTicketRepository = movieTicketRepository;
	}

	public List<MovieTicket> getTheatreNameAndShowTime(String theatreName, LocalDateTime showTime) {
		return movieTicketRepository.findByTheatreNameAndShowTime(theatreName, showTime);
	}

}
