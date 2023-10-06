package com.CFM.crudex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CFM.crudex.entity.Contact;

public interface ContactRepository extends JpaRepository< Contact, Integer>{

	List<Contact> findByName(String name);
	List<Contact> findByUserId(int id);
}

