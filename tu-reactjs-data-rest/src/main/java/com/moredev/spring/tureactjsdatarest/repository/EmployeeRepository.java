package com.moredev.spring.tureactjsdatarest.repository;

import org.springframework.data.repository.CrudRepository;

import com.moredev.spring.tureactjsdatarest.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
