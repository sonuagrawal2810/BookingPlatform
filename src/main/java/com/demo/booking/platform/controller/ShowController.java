package com.demo.booking.platform.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.booking.platform.entity.Show;
import com.demo.booking.platform.repository.ShowRepository;

@RestController
@RequestMapping("/theatres/{theatreId}/shows")
public class ShowController {
	private final ShowRepository showRepository;

	public ShowController(ShowRepository showRepository) {
		this.showRepository = showRepository;
	}

	@PostMapping
	public ResponseEntity<Show> createShow(@PathVariable Long theatreId, @RequestBody Show show) {
		// set the theatre ID for the new show
		show.setTheatreId(theatreId);

		// save the new show to the database
		Show savedShow = showRepository.save(show);

		// return the saved show with a 201 Created status code
		return ResponseEntity.status(HttpStatus.CREATED).body(savedShow);
	}

	@PutMapping("/{showId}")
	public ResponseEntity<Show> updateShow(@PathVariable Long theatreId, @PathVariable Long showId,
			@RequestBody Show show) {
		// make sure the requested show ID matches the one in the request body
		if (!showId.equals(show.getId())) {
			return ResponseEntity.badRequest().build();
		}

		// make sure the requested show belongs to the specified theatre
		Optional<Show> existingShowOptional = showRepository.findById(showId);
		if (existingShowOptional.isEmpty() || !existingShowOptional.get().getTheatreId().equals(theatreId)) {
			return ResponseEntity.notFound().build();
		}

		// update the show in the database
		Show updatedShow = showRepository.save(show);

		// return the updated show with a 200 OK status code
		return ResponseEntity.ok(updatedShow);
	}

	@DeleteMapping("/{showId}")
	public ResponseEntity<Void> deleteShow(@PathVariable Long theatreId, @PathVariable Long showId) {
		// make sure the requested show belongs to the specified theatre
		Optional<Show> existingShowOptional = showRepository.findById(showId);
		if (existingShowOptional.isEmpty() || !existingShowOptional.get().getTheatreId().equals(theatreId)) {
			return ResponseEntity.notFound().build();
		}

		// delete the show from the database
		showRepository.deleteById(showId);

		// return a 204 No Content status code
		return ResponseEntity.noContent().build();
	}
}
