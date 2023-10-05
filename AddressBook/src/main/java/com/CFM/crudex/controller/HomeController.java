package com.CFM.crudex.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.CFM.crudex.entity.Person;
import com.CFM.crudex.service.PersonServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	PersonServiceImpl service;
    @GetMapping("/")
    public String displayHome(Model model) {
    	
    		model.addAttribute("message","Hello World");
    	
        return "home";
    }
    
    @GetMapping("/book")
    public String displayBook(Model model) {
    	
    	List<Person> persons = service.getAllPersons();
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    		
    	
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
    	System.out.println(person.getId());
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
    	
    	return "book";
    }
}
