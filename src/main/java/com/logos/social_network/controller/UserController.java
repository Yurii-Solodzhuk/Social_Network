package com.logos.social_network.controller;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @ModelAttribute("user")
    public UserDto getModel(){
        return new UserDto();
    }

    @GetMapping("/settings")
    public String settings(@AuthenticationPrincipal User user, Model model){
        Integer userId = user.getId();
        model.addAttribute("id", userId);
        return "settings";
    }

    @PostMapping("/change")
    public String edit(@AuthenticationPrincipal User user,
                       @RequestParam String password,
                       @RequestParam String repeatPassword){
        userService.changePassword(user, password, repeatPassword);
        return "redirect:/settings";
    }

    @GetMapping("/photos")
    public String photos(@AuthenticationPrincipal User currentUser, Model model){
        User user = userService.getUser(currentUser.getId());
        model.addAttribute("photos", user.getPhotos());
        return "photos";
    }

    @GetMapping("/edit")
    public String editPage(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("user", user);
        return "editPage";
    }

    @GetMapping("/news")
    public String news(@AuthenticationPrincipal User currentUser, Model model){
        User user = userService.getUser(currentUser.getId());
        List<User> subscribers = user.getSubscribers();
        for (User subscriber: subscribers) {
            List<WallMessage> posts = subscriber.getSentPosts();
            model.addAttribute("posts", posts);
        }
        return "news";
    }

}
