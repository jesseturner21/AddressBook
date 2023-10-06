package com.CFM.crudex.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.Contact;

@Service
public interface ContactServiceInterface {
	
	//Create Contact
	public Contact createContact(Contact contact);
	//Get all 
	public List<Contact> getAllContacts();
	//Get Contact by Id
	public Contact getContactByID(Integer id);
	//Get Contact by Name
	public List<Contact> getContactByUserIdAndName(int id, String name);
	//Get Contact by User Id
	public List<Contact> getContactsByUserId(int id);
	//Update Contact
	public Contact updateContact(Contact person , int id);
	//Delete Contact
	public void deleteContact(int id);
	
	
	
	
	

}
