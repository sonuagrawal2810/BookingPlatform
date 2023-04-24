package com.demo.booking.platform.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieTicket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String theatreName;
	private LocalDateTime showTime;
	private List<String> seats;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

}
