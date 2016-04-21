package com.gcinemaflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcinemaflix.model.User;


public interface UserRepository extends JpaRepository<User,Integer> {
	
	public User findByUsername(String username);
	
}
