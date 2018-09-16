package com.moredev.spring.gsbuildingrestservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moredev.spring.gsbuildingrestservices.entity.Employee;
import com.moredev.spring.gsbuildingrestservices.exception.EmployeeNotFoundException;
import com.moredev.spring.gsbuildingrestservices.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	private final EmployeeRepository repository;
	
	public EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee newEmployee) {
		return repository.save(newEmployee);
	}
	
	// Single Item
	@GetMapping("/employees/{id}")
	Employee one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException("Not found Employee"));
	}
	
	@PutMapping("/employees/{id}")
	Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		
		return repository.findById(id)
				.map(emp -> {
					emp.setName(newEmployee.getName());
					emp.setRole(newEmployee.getRole());
					return repository.save(emp);
				}).orElseGet(() -> {
					newEmployee.setId(id);
					return repository.save(newEmployee);
				});
	}
	
	@DeleteMapping("/employees/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}

}
