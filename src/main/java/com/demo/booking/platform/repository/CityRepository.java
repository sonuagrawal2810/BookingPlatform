package com.demo.booking.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.booking.platform.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
	List<City> findAllByOrderByNameAsc();

}
