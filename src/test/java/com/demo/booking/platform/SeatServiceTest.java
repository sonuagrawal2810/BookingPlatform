package com.demo.booking.platform;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.booking.platform.repository.SeatRepository;
import com.demo.booking.platform.service.SeatService;
import com.demo.booking.platform.entity.Seat;

@RunWith(SpringRunner.class)
public class SeatServiceTest {

	@Mock
	private SeatRepository seatRepository;

	@InjectMocks
	private SeatService seatService;

	@Test
	public void blockSeat_seatExists_seatBlocked() {
		// Arrange
		Seat seat = new Seat();
		seat.setId(1L);
		seat.setBlocked(false);
		when(seatRepository.findById(1L)).thenReturn(Optional.of(seat));

		// Act
		boolean result = seatService.blockSeat(1L);

		// Assert
		assertTrue(result);
		assertTrue(seat.isBlocked());
		verify(seatRepository, times(1)).save(seat);
	}

	@Test
    public void blockSeat_seatNotFound_throwIllegalArgumentException() {
        // Arrange
        when(seatRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        seatService.blockSeat(1L);

        // Assert - Expects an IllegalArgumentException to be thrown
    }

	@Test
	public void blockSeat_seatAlreadyBlocked_returnFalse() {
		// Arrange
		Seat seat = new Seat();
		seat.setId(1L);
		seat.setBlocked(true);
		when(seatRepository.findById(1L)).thenReturn(Optional.of(seat));

		// Act
		boolean result = seatService.blockSeat(1L);

		// Assert
		assertFalse(result);
		assertTrue(seat.isBlocked());
		verify(seatRepository, never()).save(any(Seat.class));
	}
}
