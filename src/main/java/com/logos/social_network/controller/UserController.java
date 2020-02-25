package com.logos.social_network.controller;

import com.logos.social_network.entity.User;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("index/{userId}")
    public String index(Model model, @PathVariable(name = "userId") Integer userId){
        model.addAttribute("userId", userId);
        return "index";
    }

    @PostMapping("show/{userId}")
    public String show(Model model, @PathVariable(name = "userId") Integer userId){
        User user = userService.getOne(userId);

        model.addAttribute("user", user);
        return "index";
    }

}
