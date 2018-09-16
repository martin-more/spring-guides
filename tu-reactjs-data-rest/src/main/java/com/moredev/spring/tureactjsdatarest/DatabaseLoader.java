package com.moredev.spring.tureactjsdatarest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.moredev.spring.tureactjsdatarest.entity.Employee;
import com.moredev.spring.tureactjsdatarest.repository.EmployeeRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;
	
	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void run(String... strings) throws Exception {
		this.repository.save(new Employee("Martin", "More", "ring bearer"));
	}
	
}
