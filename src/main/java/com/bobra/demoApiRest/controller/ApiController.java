package com.bobra.demoApiRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bobra.demoApiRest.entity.User;
import com.bobra.demoApiRest.service.UserService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> findAll(){
		//retornará todos los usuarios
		return userService.findAll();
	}
	
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId){
		User user = userService.findById(userId);
		
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		//retornará al usuario con id pasado en la url
		return user;
	}
	
	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		user.setId(0);
		
		//Este metodo guardará al usuario enviado
		userService.save(user);
		
		return user;
		
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		
		userService.save(user);
		
		return user;
	}
	
	@DeleteMapping("users/{userId}")
	public String deteteUser(@PathVariable int userId) {
		
		User user = userService.findById(userId);
		
		if(user == null) {
			throw new RuntimeException("User id not found -"+userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted user id - "+userId;
	}	
}
