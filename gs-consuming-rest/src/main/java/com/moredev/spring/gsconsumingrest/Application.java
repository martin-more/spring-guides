/*
 * A RESTful service has been stood up at http://gturnquist-quoters.cfapps.io/api/random. 
 * It randomly fetches quotes about Spring Boot and returns them as a JSON document.
 * 
 * {
   type: "success",
   value: {
	      id: 10,
	      quote: "Really loving Spring Boot, makes stand alone Spring apps easy."
	   }
	}
 * 
 */

package com.moredev.spring.gsconsumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.moredev.spring.gsconsumingrest.domain.Quote;

//@SpringBootApplication
public class Application {
	
	private static final Logger log 	= LoggerFactory.getLogger(Application.class);
	private static final String ENPOINT = "http://gturnquist-quoters.cfapps.io/api/random";

//	public static void main(String[] args) {
//		RestTemplate restTemplate = new RestTemplate();
//		Quote quote = restTemplate.getForObject(ENPOINT, Quote.class);
//		log.info(quote.toString());
//		
//	}
}
