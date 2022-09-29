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
class HelloControllerRoleTest {
	
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
	
	@Test
	public void helloControllerLoginAdminTestWithAdminUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login-admin").with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "1234")))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void helloControllerLoginAdminTestWithNotAdminUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login-admin").with(SecurityMockMvcRequestPostProcessors.httpBasic("KorayB", "12")))
			.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
	
	@Test
	public void helloControllerLoginAdminTestWithourUser() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login-admin"))
			.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}
	
	@Test
	public void helloControllerLoginAdminCustomerTestWithCustomer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login-admin-customer").with(SecurityMockMvcRequestPostProcessors.httpBasic("KorayB", "12")))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void helloControllerLoginAdminCustomerTestWithAdmin() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login-admin-customer").with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "1234")))
			.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void helloControllerLoginAdminCustomerTestWithUserRole() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello-login-admin-customer").with(SecurityMockMvcRequestPostProcessors.httpBasic("Koray", "12")))
			.andExpect(MockMvcResultMatchers.status().isForbidden());
	}

}
