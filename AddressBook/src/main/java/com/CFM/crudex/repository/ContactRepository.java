package com.CFM.crudex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CFM.crudex.entity.Contact;

public interface ContactRepository extends JpaRepository< Contact, Integer>{
	
	List<Contact> findByUserIdAndId(int userId, int id);
	List<Contact> findByUserIdAndName(int id, String name);
	List<Contact> findByUserId(int id);
}

