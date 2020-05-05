package com.logos.social_network.controller;

import com.logos.social_network.entity.User;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(@AuthenticationPrincipal User currentUser, Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("users", users);
        return "adminPage";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam Integer userId,
                             @RequestParam String action){
        if (action.equals("delete")){
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }
}
