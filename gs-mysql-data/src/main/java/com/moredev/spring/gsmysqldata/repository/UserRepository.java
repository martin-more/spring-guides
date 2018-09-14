package com.moredev.spring.gsmysqldata.repository;

import org.springframework.data.repository.CrudRepository;

import com.moredev.spring.gsmysqldata.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
