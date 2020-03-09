//package com.logos.social_network.controller;
//
//import com.logos.social_network.entity.User;
//import com.logos.social_network.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/user-subscribers/{id}")
//    public String userSubscribers(
//            @AuthenticationPrincipal User currentUser,
//            @PathVariable User user,
//            Model model
//    ){
//        List<User> subscribers = user.getSubscribers();
//        model.addAttribute("subscribers", subscribers);
//
//        return "userFriends";
//    }
//
//}
