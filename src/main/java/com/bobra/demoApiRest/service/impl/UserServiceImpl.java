package com.bobra.demoApiRest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bobra.demoApiRest.entity.User;
import com.bobra.demoApiRest.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Override
	public List<User> findAll() {
		List<User> list = new ArrayList<User>();
		list.add(new User("gab", 2, "123456"));
		list.add(new User("ped", 4, "987865"));
		
		return list;
	}

	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int userId) {
		// TODO Auto-generated method stub
		
	}

}
