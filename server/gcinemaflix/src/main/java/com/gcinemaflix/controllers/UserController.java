package com.gcinemaflix.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 

import com.gcinemaflix.model.User;
//import com.gcinemaflix.service.UserService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;


@RestController
public class UserController {
	
	//@Autowired
	//private UserService userService;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public User getUser(){
		User u = new User();
		u.setId(1);
		u.setFirstName("gaurav");
		u.setLastName("bhasin");
		u.setUsername("gabhasin");
		u.setPassword("***");
		return u;
	}
	
	
}
