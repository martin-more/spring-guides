package com.moredev.spring.gsresthateoas;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//	IMPORTANT!
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(
			@RequestParam(value="name", required=false, defaultValue="Martin") String name) {
		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
		
		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}
	
}
