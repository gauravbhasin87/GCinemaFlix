package com.gcinemaflix.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.*;
import com.gcinemaflix.model.Role;
import com.gcinemaflix.model.User;
//import org.springframework.security.core.userdetails.User;
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
			else{
//				Role role = new Role();
//				role.setUser(existingUser);
//				role.setAccess(0);
//				user.setRole(role);
				user.setAccess(0);
				return userRepository.save(user);
			}
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
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException(username);
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), 
				user.getPassword().toLowerCase(),
				enabled,
				accountNonExpired,
				credentialsNonExpired,
				accountNonLocked,
				user.getAuthorities());
	}
}
