package com.frey.fizzbuzz.test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.frey.fizzbuzz.service.FizzBuzzService;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class FizzBuzzControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private FizzBuzzService service;

	@Test
	void getNumber() throws Exception {
		List<String> test = new ArrayList<>();
		test.add("1");
		test.add("2");
		test.add("Fizz");
		when(service.calculate(anyInt())).thenReturn(test);
		mockMvc.perform(get("/api/v1/fizz-buzz/numbers/3")).andExpect(status().isOk()).andExpect(content().json("[\"1\",\"2\",\"Fizz\"]"));
		verify(service, times(1)).calculate(3);
	}
}