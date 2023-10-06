package com.CFM.crudex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CFM.crudex.entity.User;

public interface UserRepository extends JpaRepository< User, Integer>{

	List<User> findByUsername(String username);
}


