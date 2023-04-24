package com.demo.booking.platform;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.booking.platform.controller.ShowController;
import com.demo.booking.platform.repository.ShowRepository;

@RunWith(SpringRunner.class)
public class ShowControllerTest {
	@Mock
	private ShowRepository showRepository;

	@InjectMocks
	private ShowController showController;

	@Test
	public void testCreateShow() {

	}

	@Test
	public void testUpdateShow() {

	}

	@Test
	public void testDeleteShow() {
	}
}