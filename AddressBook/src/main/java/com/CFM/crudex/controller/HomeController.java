package com.CFM.crudex.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    	
    		//get all people from address book 
    	List<Person> persons = service.getAllPersons();
    	System.out.print(persons);
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    		
    	
        return "book";
    }
}
