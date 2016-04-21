package com.gcinemaflix.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gcinemaflix.model.User;
import com.gcinemaflix.repository.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User create(User user){
			User existingUser = userRepository.findByUsername(user.getUsername());
			if(existingUser != null){
				return null;
			}
			else
				return userRepository.save(user);
	}
	public User delete(int id){
		User user = userRepository.findOne(id);
		userRepository.delete(user);
		return user;
	}
	
	public List<User> findAll(){
		return (List<User>) userRepository.findAll();
	}
	public User update(User user){
		User existingUser = userRepository.findByUsername(user.getUsername());
		if(existingUser == null)
			return null;
		else{
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
		}
		
		return existingUser;
	}
}
