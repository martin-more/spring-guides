package com.moredev.spring.gsresthateoas;

import static org.assertj.core.api.Assertions.*;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GreetingTraversonIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	@Test
	public void endEndpointNotHidden() throws Exception {
		Traverson traverson = new Traverson(new URI("http://localhost:"+this.port+"/greeting"), MediaTypes.HAL_JSON);
		String greeting = traverson.follow("self").toObject("$.content");
		assertThat(greeting).isEqualTo("Hello, Martin!");
	}
	
}
