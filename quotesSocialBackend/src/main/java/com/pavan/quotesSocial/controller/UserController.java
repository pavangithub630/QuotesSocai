package com.pavan.quotesSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/all")
	public List<User> getallUser(){
		return userService.getallusers();
	}
	
	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	@PutMapping(value = "/update-user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	
	
	
	
	
	

}
