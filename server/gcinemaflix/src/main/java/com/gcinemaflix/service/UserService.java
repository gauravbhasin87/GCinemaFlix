package com.gcinemaflix.service;

import java.util.List;

import com.gcinemaflix.model.User;

public interface UserService {
	
	public User create(User user);
	public User delete(int id);
	public List<User> findAll();
	public User update(User user);

}
