package com.kk.user.management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest
//@AutoConfigureMockMvc
class HelloControllerTest {
	
	@Autowired
	WebApplicationContext wac;
	
	MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders
					.webAppContextSetup(wac)
					.apply(SecurityMockMvcConfigurers.springSecurity())
					.build();
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
	public void helloControllerAuthTestWithHttpBasic() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
