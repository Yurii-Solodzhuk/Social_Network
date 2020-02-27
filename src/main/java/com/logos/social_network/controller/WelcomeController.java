package com.logos.social_network.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class WelcomeController {
    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/main")
    public String main(Model model, @RequestParam(name = "name", required = false, defaultValue = "asddsa") String name){
        model.addAttribute("name",name);
        return "main";
    }
}
