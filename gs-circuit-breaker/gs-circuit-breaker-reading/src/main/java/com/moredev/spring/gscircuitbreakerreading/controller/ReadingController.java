package com.moredev.spring.gscircuitbreakerreading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moredev.spring.gscircuitbreakerreading.service.BookService;

@RestController
public class ReadingController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/to-read")
	public String readingList() {
		return bookService.readingList();
	}

}
