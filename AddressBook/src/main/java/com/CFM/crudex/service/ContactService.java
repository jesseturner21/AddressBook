package com.CFM.crudex.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.Contact;
import com.CFM.crudex.entity.ContactComparator;
import com.CFM.crudex.repository.ContactRepository;

/**
 * Service to create all methods for JpaRepository CREATE, READ, UPDATE, DELETE
 * 
 * @author jesseturner
 *
 */
@Service
public class ContactService implements ContactServiceInterface {

	@Autowired
	ContactRepository repo; 
	
	public Contact createContact(Contact contact) {
		
		return repo.save(contact);
	}
	@Override
	public Contact getContactByUserIdAndId(int userId,int id) {
		
		return repo.findByUserIdAndId(userId, id).get(0);
		
	}
	@Override
	public List<Contact> getContactByUserIdAndName(int id,String name) {
		
		return repo.findByUserIdAndName(id, name);
	}
	@Override
	public Contact updateContact(Contact person, int id) {
		Contact old_person = repo.findById(id).orElse(null);
		old_person.setName(person.getName());
		old_person.setAddress(person.getAddress());
		old_person.setPhoneNumber(person.getPhoneNumber());
		old_person.setEmail(person.getEmail());
		repo.save(old_person);
		return old_person;
	}
	@Override
	public void deleteContact(int id) {
		repo.deleteById(id);
		
	}
	@Override
	public List<Contact> getContactsByUserId(int id) {
		
		
		List<Contact> contacts = repo.findByUserId(id);
		System.out.println(contacts);
		Collections.sort(contacts, new ContactComparator());
		System.out.println(contacts);
		return contacts;
	}
	
	
	

}
