package com.gcinemaflix.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.gcinemaflix.model.User;
//import com.gcinemaflix.service.UserService;
import com.gcinemaflix.service.UserService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<List<User>> getUser(){
		return new ResponseEntity<>(userService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<User> createUser(@RequestBody User newUser){
		User check = userService.create(newUser);
		if(check == null){
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
		else{
			
		}
		return new ResponseEntity<User>(newUser,HttpStatus.OK);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.PUT, produces="application/json")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updatedUser = userService.update(user) ;
		if(updatedUser == null)
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	
	
}
