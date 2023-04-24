package com.demo.booking.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.booking.platform.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByCitiesName(String cityName);

}
