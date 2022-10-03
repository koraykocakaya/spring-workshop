package com.kk.user.management.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.kk.user.management.entity.Customer;

@SpringBootTest
@AutoConfigureMockMvc
public class MultiTenantControllerTest {

	private static final String multitenant_URL = "/multiExample";
	private static final String multitenant_Annot_URL = "/multiExampleAnnot";

	@Autowired
	WebApplicationContext wac;
	
	@Autowired
	MockMvc mockMvc;
	
	private Customer customer1; 
			
	private Customer customer2;
	
	
	@BeforeEach
	public void setUp(){
		customer1 = Customer.builder()
							.id("1")
							.name("Customer1")
							.build();
		
		customer2 = Customer.builder()
				.id("2")
				.name("Customer2")
				.build();	
	}
	
	@Test
	void testGetCustomerIdWithNoUser() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_URL)
			.param("customerId", customer2.getId()))
				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}
	
	// csrf check
	@Test
	void testGetCustomerIdWithNoUserPost() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.post("/multiExampleUser")
			.header("_csrf", "test")
			.param("customerId", customer2.getId()))
				.andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}
	
	@Test
	void testGetCustomerIdWithAdmin() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_URL)
			.param("customerId", customer2.getId())
			.with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "1234")))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testGetCustomerIdWithCustomer() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_URL)
			.param("customerId", customer1.getId())
			.with(SecurityMockMvcRequestPostProcessors.httpBasic("KorayB", "12")))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testGetCustomerIdWithOtherCustomer() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_URL)
			.param("customerId", customer1.getId())
			.with(SecurityMockMvcRequestPostProcessors.httpBasic("KorayB2", "12")))
				.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
	
	@Test
	void testGetCustomerIdAnnotWithAdmin() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_Annot_URL)
			.param("customerId", customer2.getId())
			.with(SecurityMockMvcRequestPostProcessors.httpBasic("admin", "1234")))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testGetCustomerIdAnnotWithCustomer() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_Annot_URL)
			.param("customerId", customer1.getId())
			.with(SecurityMockMvcRequestPostProcessors.httpBasic("KorayB", "12")))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void testGetCustomerIdAnnotWithOtherCustomer() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(multitenant_Annot_URL)
			.param("customerId", customer1.getId())
			.with(SecurityMockMvcRequestPostProcessors.httpBasic("KorayB2", "12")))
				.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
}

