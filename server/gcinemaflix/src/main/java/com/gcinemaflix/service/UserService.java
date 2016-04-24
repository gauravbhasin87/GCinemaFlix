package com.gcinemaflix.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gcinemaflix.model.User;

public interface UserService extends UserDetailsService{
	
	public User create(User user);
	public User delete(int id);
	public List<User> findAll();
	public User update(User user);

}
