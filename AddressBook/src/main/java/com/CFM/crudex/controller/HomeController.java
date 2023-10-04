package com.CFM.crudex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String displayHome(Model model) {
    	
    		model.addAttribute("message","Hello World");
    	
        return "home";
    }
    @GetMapping("/book")
    public String displayBook(Model model) {
    	
    		model.addAttribute("message","Address Book");
    	
        return "book";
    }
}
