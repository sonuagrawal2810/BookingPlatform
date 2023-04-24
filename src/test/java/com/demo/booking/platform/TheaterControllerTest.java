package com.demo.booking.platform;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.booking.platform.entity.Theater;
import com.demo.booking.platform.service.TheaterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class TheaterControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TheaterService theaterService;

	@Test
	public void testGetTheatersByCityAndMovieName() throws Exception {
		Theater theater1 = new Theater("Theater 1", "New York", "Movie 1");
		Theater theater2 = new Theater("Theater 2", "New York", "Movie 1");
		List<Theater> theaters = Arrays.asList(theater1, theater2);
		when(theaterService.getTheatersByCityAndMovieName("New York", "Movie 1")).thenReturn(theaters);

		mockMvc.perform(get("/theaters/New York/movies/Movie 1")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2))).andExpect(jsonPath("$[0].name", is("Theater 1")))
				.andExpect(jsonPath("$[1].name", is("Theater 2")));

		verify(theaterService, times(1)).getTheatersByCityAndMovieName("New York", "Movie 1");
	}

}
