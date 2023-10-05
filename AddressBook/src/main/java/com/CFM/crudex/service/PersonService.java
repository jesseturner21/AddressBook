package com.CFM.crudex.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.CFM.crudex.entity.Person;

@Service
public interface PersonService {
	//Create Person
	public Person createPerson(Person person);
	//Get all 
	public List<Person> getAllPersons();
	//Get Person by Id
	public Person getPersonByID(Integer id);
	//Get Person by Name
	public List<Person> getPersonByName(String name);
	//Update person
	public Person updatePerson(Person person, int id);
	//Delete person
	public void deletePerson(int id);
	
	

}
