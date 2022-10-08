package com.lloyds.clock.HumanFriendlyClock;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
class HumanFriendlyClockApplicationTests extends AbstractTest {

	@Override
	@BeforeEach
	public void setUp() {
		super.setUp();
	}

	@Test
	public void getTimeWithZeroMinutes() throws Exception {

		String uri = "/clock/?time=18:00";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String time = mvcResult.getResponse().getContentAsString();
		assertEquals("Six o' clock ", time);
	}
	
	@Test
	public void getTimeWithThirtyMinutes() throws Exception {

		String uri = "/clock/?time=18:30";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String time = mvcResult.getResponse().getContentAsString();
		assertEquals("Half past six", time);
	}
	
	@Test
	public void getTimeWithLessThanThirtyMinutes() throws Exception {

		String uri = "/clock/?time=18:29";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String time = mvcResult.getResponse().getContentAsString();
		assertEquals("Twenty nine past six", time);
	}

	@Test
	public void getTimeWithGreaterThanThirtyMinutes() throws Exception {

		String uri = "/clock/?time=18:55";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String time = mvcResult.getResponse().getContentAsString();
		assertEquals("Five to seven", time);
	}
	
	@Test
	public void getTimeWithoutInput() throws Exception {

		String uri = "/clock/";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void getTimeWithIncorrectFormat() throws Exception {

		String uri = "/clock/?time=18,55";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status); //Incorrect format, the return return will be current time in human readable format but error will be printed in log.
	}
	
	
}
