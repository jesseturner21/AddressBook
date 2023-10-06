package com.CFM.crudex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CFM.crudex.entity.User;

public interface UserRepository extends JpaRepository< User, Integer>{

	User findByUsername(String username);
}


