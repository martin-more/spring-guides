package com.moredev.spring.gsbuildingrestservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moredev.spring.gsbuildingrestservices.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
