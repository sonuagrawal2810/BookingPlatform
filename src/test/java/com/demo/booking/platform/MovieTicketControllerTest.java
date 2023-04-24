package com.demo.booking.platform;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.booking.platform.controller.MovieController;
import com.demo.booking.platform.entity.MovieTicket;
import com.demo.booking.platform.repository.MovieTicketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
class MovieTicketControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MovieTicketRepository movieTicketRepository;

	@Test
	public void testBookMovieTicket() throws Exception {
		movieTicketRepository.deleteAll();
		String requestBody = "{\"theatreName\": \"ABC Theatre\", \"showTime\": \"2023-04-25T10:30:00\", \"seats\": [\"A1\", \"A2\"]}";
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.post("/movie-tickets").content(requestBody)
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		String response = result.getResponse().getContentAsString();
		MovieTicket savedTicket = new ObjectMapper().readValue(response, MovieTicket.class);
		assertThat(savedTicket.getId(), notNullValue());
		assertThat(savedTicket.getTheatreName(), equalTo("ABC Theatre"));
		assertThat(savedTicket.getShowTime(), equalTo(LocalDateTime.parse("2023-04-25T10:30:00")));
		assertThat(savedTicket.getSeats(), containsInAnyOrder("A1", "A2"));
	}

	@Test
	public void testBookMovieTicketWithExistingSeats() throws Exception {
		movieTicketRepository.deleteAll();
		MovieTicket existingTicket = new MovieTicket();
		existingTicket.setTheatreName("test");
	}
}
