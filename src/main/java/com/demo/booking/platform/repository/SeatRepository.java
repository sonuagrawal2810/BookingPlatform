package com.demo.booking.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.demo.booking.platform.entity.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
