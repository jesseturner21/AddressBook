package com.CFM.crudex.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CFM.crudex.service.PersonService;

@Controller
public class HomeController {
	
	@Autowired
	PersonService service;
    @GetMapping("/")
    public String displayHome(Model model) {
    	
    		model.addAttribute("message","Hello World");
    	
        return "home";
    }
    
    
}
