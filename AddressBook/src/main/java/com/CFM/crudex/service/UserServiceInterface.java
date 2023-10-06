package com.CFM.crudex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.User;

@Service
public interface UserServiceInterface {
	
	    //Create User
		public User createUser(User user);
		//Get User by Username
		public List<User> getUserByUsername(String username);
}
