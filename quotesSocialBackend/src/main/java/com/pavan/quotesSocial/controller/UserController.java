package com.pavan.quotesSocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pavan.quotesSocial.Enitity.User;
import com.pavan.quotesSocial.exceptions.UserException;
import com.pavan.quotesSocial.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<User>> getallUser(){
		
		try {
			List<User> users= userService.getallusers();
			return new ResponseEntity<List<User>>(users,HttpStatus.OK);
		} catch (Exception e) {
			throw new UserException(e.getMessage());
		}
		
		
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {

		try {
			User user2 = userService.addUser(user);
			return new ResponseEntity<User>(user2, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			throw new UserException("Enter Unique User Name");
		}

	}
	@PutMapping(value = "/update-user")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		try {
			User user2= userService.updateUser(user);
			return new ResponseEntity<User>(user2, HttpStatus.OK);
		} catch (DataIntegrityViolationException e) {
			throw new UserException(e.getRootCause().getLocalizedMessage());
		}
		
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> findUserByUserId(@PathVariable("userId") long userId){
		
		try {
			User user= userService.findUserByUserId(userId);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} catch (Exception e) {
			throw  new UserException(e.getMessage());
		}
		
		
	}
	
	
	
	
	
	
	
	

}
