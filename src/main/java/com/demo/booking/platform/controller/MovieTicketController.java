package com.demo.booking.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.booking.platform.entity.MovieTicket;
import com.demo.booking.platform.repository.MovieTicketRepository;

@RestController
@RequestMapping("/movie-tickets")
public class MovieTicketController {
    @Autowired
    private MovieTicketRepository movieTicketRepository;

    @PostMapping
    public ResponseEntity<MovieTicket> bookMovieTicket(@RequestBody MovieTicket movieTicket) {
        List<MovieTicket> existingTickets = movieTicketRepository.findByTheatreNameAndShowTime(movieTicket.getTheatreName(), movieTicket.getShowTime());
        for (String seat : movieTicket.getSeats()) {
            for (MovieTicket existingTicket : existingTickets) {
                if (existingTicket.getSeats().contains(seat)) {
                    return ResponseEntity.badRequest().build();
                }
            }
        }
        MovieTicket savedTicket = movieTicketRepository.save(movieTicket);
        return ResponseEntity.ok(savedTicket);
    }
}
