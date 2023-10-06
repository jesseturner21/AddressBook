package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.CFM.crudex.entity.Contact;
import com.CFM.crudex.entity.SearchData;
import com.CFM.crudex.entity.User;
import com.CFM.crudex.service.ContactService;

@Controller
public class LoginController {
	
	@Autowired
	ContactService service;
	
	
	@GetMapping("/login")
	public String displayLogin(Model model) {
		model.addAttribute("message", "Login");
		model.addAttribute("user", new User());
		
		return "login";
		
	}
	@PostMapping("/account")
	public String userAccount(User user, Model model) {
		//insert login validation
		
		List<Contact> persons = service.getAllContacts();
    	model.addAttribute("persons",persons);
    	model.addAttribute("message","Address Book");
    	model.addAttribute("searchData", new SearchData());
		return "book";
	}
}
