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
import com.CFM.crudex.service.ContactService;
import com.CFM.crudex.service.UserService;


@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	ContactService service;
	@Autowired
	UserService uService;
	
	@GetMapping("/login")
	public String displayLogin(Model model) {
		model.addAttribute("message", "Login");
		model.addAttribute("user", new User());
		
		return "login";
		
	}
	@PostMapping("/account")
	public String userAccount(User user, Model model) {
		//TODO:insert login validation
		user = uService.getUserByUsername(user.getUsername()).get(0);
		List<Contact> contacts = user.getContacts();
		
		model.addAttribute("title", "Address Book:" + user.getUsername());
		model.addAttribute("user", user);
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
		
		return "book";
	}
}
