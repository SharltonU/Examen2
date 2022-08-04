package com.sharlton.examen2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    private String homePage(Model model){
        return "index";
    }
}
