package com.kk.user.management.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginAuthControllerTest {

	@Autowired
	MockMvc mockMvc;

	
	@Test
	public void testgetLoginCustomAuth() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/loginCustomAuth")
		.header("Api-key", "KorayB")
		.header("Api-secret", "12"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
