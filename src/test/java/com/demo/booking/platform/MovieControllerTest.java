package com.demo.booking.platform;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.booking.platform.controller.MovieController;
import com.demo.booking.platform.entity.Movie;
import com.demo.booking.platform.service.MovieService;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
class MovieControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MovieService movieService;

	@Test
	public void testGetMoviesByCity() throws Exception {
		String city = "New York";
		List<Movie> expectedMovies = Arrays.asList(new Movie("Movie A", city), new Movie("Movie B", city));
		Mockito.when(movieService.getMoviesByCity(city)).thenReturn(expectedMovies);
		mockMvc.perform(MockMvcRequestBuilders.get("/movies/" + city)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].title", Matchers.is("Movie A")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].city", Matchers.is(city)))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].title", Matchers.is("Movie B")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].city", Matchers.is(city)));
	}
}
