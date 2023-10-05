package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CFM.crudex.entity.Person;
import com.CFM.crudex.service.PersonServiceImpl;

@RestController
@Controller
@RequestMapping("")
public class PersonController {
	
	@Autowired
	PersonServiceImpl service;
	@PostMapping("/save")
	public Person savePerson(@RequestBody Person person) {
		return service.createPerson(person);
	}
	
	@GetMapping("/get/all")
	public List<Person> getAllPersons() {
		return service.getAllPersons();
	}
	
	@GetMapping("/get/{id}")
	public Person getPerson(@PathVariable Integer id) {
		return service.getPersonByID(id);
	}
	
	@PutMapping("/update/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable int id) {
		return service.updatePerson(person, id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable int id) {
		service.deletePerson(id);
		return new ResponseEntity<String>("Successful deletion of Id "+ id, HttpStatus.OK);
	}
}
