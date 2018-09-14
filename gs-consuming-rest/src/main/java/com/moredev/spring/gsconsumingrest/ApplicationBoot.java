package com.moredev.spring.gsconsumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.moredev.spring.gsconsumingrest.domain.Quote;

@SpringBootApplication
public class ApplicationBoot {

	private static final Logger log = LoggerFactory.getLogger(ApplicationBoot.class);
	private static final String ENPOINT = "http://gturnquist-quoters.cfapps.io/api/random";
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationBoot.class);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(ENPOINT, Quote.class);
			log.info(quote.toString());
		};
	}
	
}
