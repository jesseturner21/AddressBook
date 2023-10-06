package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CFM.crudex.entity.Contact;
import com.CFM.crudex.service.ContactService;
/**
 * Controller for the functionality on API, CRUD
 * @author jesseturner
 *
 */

@RestController
@RequestMapping("")
public class ContactController {
	
	@Autowired
	ContactService service;
	@PostMapping("/save")
	public Contact savePerson(@RequestBody Contact person) {
		return service.createContact(person);
	}
	
	@GetMapping("/get/all")
	public List<Contact> getAllPersons() {
		return service.getAllContacts();
	}
	
	@GetMapping("/get/{id}")
	public Contact getPerson(@PathVariable Integer id) {
		return service.getContactByID(id);
	}
	
	@PutMapping("/update/{id}")
	public Contact updatePerson(@RequestBody Contact person, @PathVariable int id) {
		return service.updateContact(person, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id) {
		service.deleteContact(id);
		return new ResponseEntity<String>("Successful deletion of Id "+ id, HttpStatus.OK);
	}
}
