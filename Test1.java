package com.javasampleapproach.h2;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Autowired
	private TestRestTemplate restTemplate;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testInitialDisplay() throws Exception {

		String body1 = this.restTemplate.getForObject("/save/saveRoleOperationFeature", String.class);
		String body2 = this.restTemplate.getForObject("/save/saveRole", String.class);
		String body3 = this.restTemplate.getForObject("/save/saveUser", String.class);

		System.out.println(body1 + body2 + body3);

		assertNotNull(body1 + body2 + body3);

	}

	@Test
	@WithMockUser(username = "anil", password = "anil")
	public void validateGetAllUsersInfo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllUsersInfo").accept(MediaType.ALL))
				.andExpect(status().isOk());
	}

}
