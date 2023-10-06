package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.CFM.crudex.entity.Contact;
import com.CFM.crudex.entity.SearchData;
import com.CFM.crudex.entity.User;
import com.CFM.crudex.service.UserService;

@Controller
@SessionAttributes("user")
public class SignUpController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/signup")
	public String displaySignUp(Model model) {
		
		model.addAttribute("title", "Sign Up");
		model.addAttribute("user", new User());
		
		return "signup";
	}
	
	@PostMapping("/newUser")
	public String createNewUser(Model model, User user) {
		
		service.createUser(user);
		
		List<Contact> contacts = user.getContacts();
		
		model.addAttribute("title", "Address Book: " + user.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
		
		
		return "book";
	}

}
