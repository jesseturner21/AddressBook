package com.CFM.crudex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.CFM.crudex.entity.Contact;
import com.CFM.crudex.entity.SearchData;
import com.CFM.crudex.entity.User;
import com.CFM.crudex.service.ContactService;
import com.CFM.crudex.service.UserService;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	ContactService service;
	@Autowired
	UserService uService;
	
	@GetMapping({"/", "/login"})
	public String displayLogin(Model model) {
		model.addAttribute("title", "Login");
		model.addAttribute("user", new User());
		
		return "login";
		
	}
	@PostMapping("/account")
	public String userAccount(@Valid User user,  BindingResult bindingResult, Model model) {
		
		// CHECK FIELDS
		if (bindingResult.hasErrors()) {

			model.addAttribute("title", "Login");
	        return "login"; 
	    }
		// CHECK USER EXISTS
		if(uService.getUserByUsername(user.getUsername()).isEmpty()) {
			model.addAttribute("title", "Login");
			bindingResult.rejectValue("username", "wrong.username", "Username does not exist");
			
			return "login";
		}
		
		// CHECK PASSWORD
		// Get password for comparison, takes username - gets user - gets user password
		String realPassword = uService.getUserByUsername(user.getUsername()).get(0).getPassword();
		
		//Compare, if wrong reject 
		if(!realPassword.equals(user.getPassword())) {
			model.addAttribute("title", "Login");
			bindingResult.rejectValue("password", "wrong.password", "Incorrect Password or Username");
			
			return "login";
		}
		
		// GET ACCOUNT
		user = uService.getUserByUsername(user.getUsername()).get(0);
		List<Contact> contacts = service.getContactsByUserId(user.getId());
		
		model.addAttribute("user", user);
		model.addAttribute("contacts", contacts);
		model.addAttribute("searchData", new SearchData());
		
		return "book";
	}
}
