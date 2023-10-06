package com.CFM.crudex.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.Contact;

@Service
public interface ContactServiceInterface {
	
	//Create Contact
	public Contact createContact(Contact person);
	//Get all 
	public List<Contact> getAllContacts();
	//Get Contact by Id
	public Contact getContactByID(Integer id);
	//Get Contact by Name
	public List<Contact> getContactByName(String name);
	//Update Contact
	public Contact updateContact(Contact person , int id);
	//Delete Contact
	public void deleteContact(int id);
	
	
	
	

}
