package com.logos.social_network.controller;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.service.UserService;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private WallMessageService wallMessageService;

    @ModelAttribute("user")
    public UserDto getModel(){
        return new UserDto();
    }

    @GetMapping("/settings")
    public String settings(@AuthenticationPrincipal User user, Model model){
        Integer userId = user.getId();
        model.addAttribute("id", userId);
        model.addAttribute("currentUser", user);
        return "settings";
    }

    @PostMapping("/change")
    public String changePassword(@AuthenticationPrincipal User curentUser,
                                 @ModelAttribute("user")UserDto userDto){
        User user = userService.getUser(curentUser.getId());
        userService.changePassword(user, userDto);
        return "redirect:/settings";
    }

    @GetMapping("/photos")
    public String photos(@AuthenticationPrincipal User currentUser, Model model){
        User user = userService.getUser(currentUser.getId());
        model.addAttribute("photos", user.getPhotos());
        model.addAttribute("currentUser", currentUser);
        return "photos";
    }

    @GetMapping("/edit")
    public String editPage(@AuthenticationPrincipal User currentUser, Model model){
        User user = userService.getUser(currentUser.getId());
        model.addAttribute("currentUser", user);
        return "editPage";
    }

    @PostMapping("/edit-user")
    public String  edit(@AuthenticationPrincipal User currentUser,
                        @ModelAttribute("user")UserDto userDto){
        User user = userService.getUser(currentUser.getId());
        userService.editUserFields(user, userDto);
        return "redirect:/edit";
    }

    @GetMapping("/news")
    public String news(@AuthenticationPrincipal User currentUser, Model model){
        User user = userService.getUser(currentUser.getId());
        List<WallMessage> posts = new ArrayList<>();
        List<User> subscribtions = user.getSubscription();
        for (User subscribtion: subscribtions) {
            posts.addAll(subscribtion.getSentPosts());
        }
        model.addAttribute("posts", posts);
        model.addAttribute("currentUser", currentUser);
        return "news";
    }

    @PostMapping("/upload-avatar")
    public String upload(@RequestParam(name = "avatarURL") MultipartFile multipartFile,
                         @AuthenticationPrincipal User currentUser) throws IOException {
        User user = userService.getUser(currentUser.getId());
        userService.addAvatar(user, multipartFile);
        return "redirect:/edit";
    }

    @GetMapping("/subscribe/{user}")
    public String subscribe(@AuthenticationPrincipal User currentUser,
                            @PathVariable User user){
        userService.subscribe(currentUser, user);
        return "redirect:/" + user.getId();
    }

    @GetMapping("/unsubscribe/{user}")
    public String unsubscribe(@AuthenticationPrincipal User currentUser,
                              @PathVariable User user){
        userService.unubscribe(currentUser, user);
        return "redirect:/" + user.getId();
    }

    @GetMapping("/{type}/{user}/list")
    public String userList(@AuthenticationPrincipal User currentUser,
                           @PathVariable User user,
                           @PathVariable String type,
                           Model model){
        model.addAttribute("user", user);
        model.addAttribute("type", type);
        model.addAttribute("currentUser", currentUser);
        if ("subscriptions".equals(type)){
            model.addAttribute("subscriptions", user.getSubscription());
        }else {
            model.addAttribute("subscriptions", user.getSubscribers());
        }
        return "subscriptions";
    }

    @GetMapping("{user}/{post}/like")
    public String like(@AuthenticationPrincipal User currnetUser,
                       @PathVariable WallMessage post,
                       @PathVariable User user){
        wallMessageService.like(currnetUser, post);
        return "redirect:/" + user.getId();
    }

}
