package com.demo.booking.platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.booking.platform.entity.Show;
import com.demo.booking.platform.repository.ShowRepository;

@Service
public class ShowService {
	private final ShowRepository showRepository;

	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	public List<Show> getTheatreId(Long theatreId){
		return showRepository.findByTheatreId(theatreId);
	}

}
