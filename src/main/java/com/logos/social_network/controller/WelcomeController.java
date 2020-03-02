package com.logos.social_network.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }
}
