package com.CFM.crudex.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.Person;
import com.CFM.crudex.entity.PersonComparator;
import com.CFM.crudex.repository.PersonRepository;

/**
 * Service to create all methods for JpaRepository CREATE, READ, UPDATE, DELETE
 * 
 * @author jesseturner
 *
 */
@Service
public class PersonService implements PersonServiceInterface {

	@Autowired
	PersonRepository repo; 
	
	public Person createPerson(Person person) {
		
		return repo.save(person);
	}
	@Override
	public List<Person> getAllPersons() {
		
		List<Person> persons = repo.findAll();
		
		Collections.sort(persons, new PersonComparator());
		
		return persons;
	}
	@Override
	public Person getPersonByID(Integer id) {
		
		return repo.findById(id).orElse(null);
		
	}
	@Override
	public List<Person> getPersonByName(String name) {
		
		return repo.findByName(name);
	}
	@Override
	public Person updatePerson(Person person, int id) {
		Person old_person = repo.findById(id).orElse(null);
		old_person.setName(person.getName());
		old_person.setAddress(person.getAddress());
		old_person.setPhoneNumber(person.getPhoneNumber());
		old_person.setEmail(person.getEmail());
		repo.save(old_person);
		return old_person;
	}
	@Override
	public void deletePerson(int id) {
		repo.deleteById(id);
		
	}
	
	

}
