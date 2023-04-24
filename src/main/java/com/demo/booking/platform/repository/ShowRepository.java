package com.demo.booking.platform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.booking.platform.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
	List<Show> findByTheatreId(Long theatreId);
}
