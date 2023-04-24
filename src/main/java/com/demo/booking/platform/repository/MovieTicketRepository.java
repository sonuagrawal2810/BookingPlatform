package com.demo.booking.platform.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.booking.platform.entity.MovieTicket;

@Repository
public interface MovieTicketRepository extends JpaRepository<MovieTicket, Long> {
	List<MovieTicket> findByTheatreNameAndShowTime(String theatreName, LocalDateTime showTime);
}