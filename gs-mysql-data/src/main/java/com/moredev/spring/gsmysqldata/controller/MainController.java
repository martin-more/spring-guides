package com.moredev.spring.gsmysqldata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moredev.spring.gsmysqldata.entity.User;
import com.moredev.spring.gsmysqldata.repository.UserRepository;

@Controller
@RequestMapping(path="/demo")
public class MainController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping(path="/add")
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User u = new User();
		u.setName(name);
		u.setEmail(email);
		userRepository.save(u);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	
}
