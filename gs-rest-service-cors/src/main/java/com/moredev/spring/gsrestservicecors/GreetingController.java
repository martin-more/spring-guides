package com.moredev.spring.gsrestservicecors;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/*
	 * 	Enabling CORS
	 *  Controller method CORS configuration
	 *  ------------------------------------
	 *  So that the RESTful web service will include CORS access control 
	 *  headers in its response, you just have to add a @CrossOrigin 
	 *  annotation to the handler method
	 *  
	 *  @CrossOrigin annotation enables cross-origin only for this specific
	 *  method. By default, its allows:
	 *  	- all origins, 
	 *  	- all headers, 
	 *  	- the HTTP methods specified in the @RequestMapping annotation  and
	 *  	- a maxAge of 30 minutes is used
	 *  
	 *  
	 *  It is also possible to add this annotation at controller class level 
	 *  as well, in order to enable CORS on all handler methods of this class.
	 */
	@CrossOrigin(origins="http://localhost:9000")
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(required=false, defaultValue="World") String name) {
		System.out.println("=== in greeting ===");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	

	/*
	 * Global CORS configuration
	 * -------------------------
	 * As an alternative to fine-grained annotation-based configuration, 
	 * you can also define some global CORS configuration as well. 
	 * This is similar to using a 'Filter' based solution
	 */
	@GetMapping("/greeting-javaconfig")
	public Greeting greetingWithJavaConfig(@RequestParam(required=false, defaultValue="Martin") String name) {
		System.out.println("=== in greetingWithJavaConfig ===");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
}