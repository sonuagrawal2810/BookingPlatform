package com.demo.booking.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.booking.platform.service.SeatService;

@RestController
@RequestMapping("/seats")
public class SeatController {

	@Autowired
	private SeatService seatService;

	@PostMapping("/{seatId}/book")
	public ResponseEntity<String> bookSeat(@PathVariable("seatId") Long seatId) {
		boolean isSeatBlocked = seatService.blockSeat(seatId);
		if (isSeatBlocked) {
			return ResponseEntity.ok("Seat booked successfully!");
		} else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Seat already booked, please choose another seat!");
		}
	}
}
