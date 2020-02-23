package com.logos.social_network.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

    @GetMapping("index/{userId}")
    public String index(Model model, @PathVariable(name = "userId") Integer userId){
        model.addAttribute("userId", userId);
        return "index";
    }

}
