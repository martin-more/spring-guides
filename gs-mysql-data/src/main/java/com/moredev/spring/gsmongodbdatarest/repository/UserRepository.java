package com.moredev.spring.gsmongodbdatarest.repository;

import org.springframework.data.repository.CrudRepository;

import com.moredev.spring.gsmongodbdatarest.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
