package com.kk.user.management.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {
	
	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
//		mockMvc = MockMvcBuilders
//					.webAppContextSetup(wac)
//					.apply(SecurityMockMvcConfigurers.springSecurity())
//					.build();
	}
	
	// Herhangi bir user ile de burada hata vermeyecektir, security gececektir
	@WithMockUser(username = "user2")
	@Test
	public void helloControllerTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void helloControllerTestWithHttpBasic() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello").with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "1234")))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void helloControllerTestDifferentUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login").with(SecurityMockMvcRequestPostProcessors.httpBasic("Koray", "12")))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	


}
