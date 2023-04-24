package com.demo.booking.platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.booking.platform.entity.Seat;
import com.demo.booking.platform.repository.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public boolean blockSeat(Long seatId) {
        Seat seat = seatRepository.findById(seatId).orElse(null);
        if (seat == null) {
            throw new IllegalArgumentException("Seat not found");
        }

        if (seat.isBlocked()) {
            return false;
        } else {
            seat.setBlocked(true);
            seatRepository.save(seat);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    seat.setBlocked(false);
                    seatRepository.save(seat);
                    timer.cancel();
                }
            }, 30000); // unblock the seat after 30 seconds

            return true;
        }
    }
}

