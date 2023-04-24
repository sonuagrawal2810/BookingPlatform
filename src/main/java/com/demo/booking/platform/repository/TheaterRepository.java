package com.demo.booking.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.booking.platform.entity.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long> {
	List<Theater> findByCityAndMovieName(String city, String movieName);
}
