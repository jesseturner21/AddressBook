package com.CFM.crudex.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.User;
import com.CFM.crudex.repository.UserRepository;

/**
 * Service to create all methods for JpaRepository CREATE, READ, UPDATE, DELETE
 * 
 * @author jesseturner
 *
 */
@Service
public class UserService implements UserServiceInterface {

	@Autowired
	UserRepository repo; 
	
	public User createUser(User user) {
		
		return repo.save(user);
	}
	@Override
	public List<User> getUserByUsername(String username) {
		
		return repo.findByUsername(username);
	}
}
	
	
	
	


