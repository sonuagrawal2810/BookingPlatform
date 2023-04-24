package com.demo.booking.platform.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.booking.platform.entity.City;
import com.demo.booking.platform.repository.CityRepository;

@Service
public class CityService {
	private final CityRepository cityRepository;

	public CityService(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	public List<City> findAll() {
		return cityRepository.findAllByOrderByNameAsc();
	}

}
