package com.CFM.crudex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String displayLogin(Model model) {
		model.addAttribute("message", "Login");
		return "login";
		
	}
}
