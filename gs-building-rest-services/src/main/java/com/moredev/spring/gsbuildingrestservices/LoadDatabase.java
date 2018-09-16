package com.moredev.spring.gsbuildingrestservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moredev.spring.gsbuildingrestservices.entity.Employee;
import com.moredev.spring.gsbuildingrestservices.repository.EmployeeRepository;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Martin", "Assistant Solution")));
			log.info("Preloading " + repository.save(new Employee("More", "Developer")));
		};
	}
}
