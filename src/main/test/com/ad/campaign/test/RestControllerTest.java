package com.ad.campaign.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.ad.campaign.rest.PartnerAdRestService;

@RunWith(SpringJUnit4ClassRunner.class)
public class RestControllerTest extends AbstractContextControllerTests {

	private MockMvc mockMvc;
	
	@Autowired
	private PartnerAdRestService partnerAdRestService;
	
//	@Autowired
//	protected WebApplicationContext wac;

	@Before
	public void setup() throws Exception {
		this.mockMvc = standaloneSetup(partnerAdRestService).build();
	}

	@Test
	public void getServiceTest() throws Exception {
		this.mockMvc.perform(get("/service/ad/123456"))
				.andExpect(status().isOk())
				.andExpect(content().json("{ \"partner_id\": \"123456\", "
						+ "\"duration\": 20, \"ad_content\":"
						+ " \"test ad content\" }"));
	}
	
	@Test
	public void getServiceTestNoContent() throws Exception {
		this.mockMvc.perform(get("/service/ad/12345"))
				.andExpect(status().isNoContent())
				.andExpect(content().string(""));
	}

	@Test
	public void postServiceTest() throws Exception {
		this.mockMvc.perform(post("/service/ad")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"partner_id\": \"123456\", "
						+ "\"duration\": 20, \"ad_content\":"
						+ " \"test ad content\" }"))
						.andExpect(status().isCreated())
			.andExpect(content().string("123456"));
	}
	
}
