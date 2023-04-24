package com.demo.booking.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.demo.booking.platform.entity")
public class BookingPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingPlatformApplication.class, args);
	}

}
