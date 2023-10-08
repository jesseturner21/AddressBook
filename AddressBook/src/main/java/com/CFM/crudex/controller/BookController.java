package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.CFM.crudex.entity.Contact;
import com.CFM.crudex.entity.SearchData;
import com.CFM.crudex.entity.User;
import com.CFM.crudex.service.ContactService;
import com.CFM.crudex.service.UserService;

import jakarta.validation.Valid;
/**
 * Controller for the functionality on the book page, CRUD and search
 * @author jesseturner
 *
 */
@Controller
public class BookController {
	
	@Autowired
	ContactService service;
	@Autowired
	UserService uService;
	
    
    @GetMapping("/add")
    public String createPerson(Model model, @SessionAttribute("user") User user) {
    	
    	model.addAttribute("title", "Contact for " + user.getUsername());
    	model.addAttribute("contact", new Contact());
    	
    	return "add";
    }
    
    @GetMapping("/edit/{id}")
    public String editPerson(Model model, @PathVariable int id, @SessionAttribute("user") User user) {
    	
    	
    	Contact contact = service.getContactByUserIdAndId(user.getId(), id);
    	model.addAttribute("title", "Contact for " + user.getUsername());
    	model.addAttribute("contact", contact);
    	
        return "add";
    }
    
    @PostMapping("/submit")
    public String submit(@Valid Contact contact, BindingResult bindingResult, @SessionAttribute("user") User user, Model model) {
    	
    	if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Contact for " + user.getUsername());
			return "add";
    	}
    	
    	contact.setUser(user);
    	
    	//if the id is zero, check fields then create
    	if(contact.getId() == 0) {
    		service.createContact(contact);
    	}
    	// if they have id, check fields then update 
    	else {
    		service.updateContact(contact, contact.getId());
    	}
    	
    	//set the contacts to all contacts with users id
    	user.setContacts(service.getContactsByUserId(user.getId()));
    	
    	List<Contact> contacts = user.getContacts();
		
		model.addAttribute("title", "Address Book: " + user.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
    	
    	return "book";
    }
    
    @GetMapping("/delete/{id}")
    public String delete(Model model,@SessionAttribute("user") User user, @PathVariable int id) {
    	
    	service.deleteContact(id);
    	//reset the contacts
    	user.setContacts(service.getContactsByUserId(user.getId()));
    	
    	List<Contact> contacts = user.getContacts();
		
		model.addAttribute("title", "Address Book: " + user.getUsername());
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
    	
    	return "book";
    }
    
    @PostMapping("/search")
    public String search(Model model, @SessionAttribute("user") User user, SearchData searchData) {
    	
    	model.addAttribute("title", "Address Book: " + user.getUsername());
		List<Contact> contacts = service.getContactByUserIdAndName(user.getId(), searchData.getName());
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
    	
    	return "book";
    }
    
    @GetMapping("all")
    public String all(Model model, @SessionAttribute("user") User user) {
    	
    	model.addAttribute("title", "Address Book: " + user.getUsername());
		List<Contact> contacts = service.getContactsByUserId(user.getId());
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
		
		return "book";
    }
    
    
}
