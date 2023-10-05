package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CFM.crudex.entity.Person;
import com.CFM.crudex.entity.SearchData;
import com.CFM.crudex.service.PersonService;
/**
 * Controller for the functionality on the book page, CRUD and search
 * @author jesseturner
 *
 */
@Controller
public class BookController {
	
	@Autowired
	PersonService service;
	
    @GetMapping("/book")
    public String displayBook(Model model) {
    	List<Person> persons = service.getAllPersons();
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    	model.addAttribute("searchData", new SearchData());
    		
    	
        return "book";
    }
    
    @GetMapping("/add")
    public String createPerson(Model model) {
    	
    	model.addAttribute("person", new Person());
    	
    	return "add";
    }
    
    @GetMapping("/edit/{id}")
    public String editPerson(Model model, @PathVariable int id) {
    	
    	Person person = service.getPersonByID(id);
    	model.addAttribute("person", person);
    	
        return "add";
    }
    
    @PostMapping("/submit")
    public String submit(Person person, Model model) {
    	//if the id is zero the person is being created
    	if(person.getId() == 0) {
    		service.createPerson(person);
    	}
    	// if they have id then update 
    	else {
    		service.updatePerson(person, person.getId());
    	}
    	
    	List<Person> persons = service.getAllPersons();
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    	model.addAttribute("searchData", new SearchData());
    	
    	return "book";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id) {
    	
    	service.deletePerson(id);
    	
    	List<Person> persons = service.getAllPersons();
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    	model.addAttribute("searchData", new SearchData());
    	
    	return "book";
    }
    
    @PostMapping("/search")
    public String search(Model model, SearchData searchData) {
    	
    	List<Person> persons = service.getPersonByName(searchData.getName());
    	System.out.println(persons);
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    	model.addAttribute("searchData", new SearchData());
    	
    	return "book";
    }
    
    
}
