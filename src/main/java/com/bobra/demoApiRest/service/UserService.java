package com.bobra.demoApiRest.service;

import java.util.List;

import com.bobra.demoApiRest.entity.User;


public interface UserService {

	List<User> findAll();

	User findById(int userId);

	void save(User user);

	void deleteById(int userId);

}
