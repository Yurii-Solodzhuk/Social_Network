package com.logos.social_network.controller;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.repository.WallMessageRepository;
import com.logos.social_network.service.UserService;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


//    @Autowired
//    private WallMessageRepository wallMessageRepository;
//    @Autowired
//    private WallMessageService wallMessageService;
//
//    @ModelAttribute("post")
//    public WallMessageDto getPost(){return new WallMessageDto();}
//
//    @ModelAttribute("user")
//    public UserDto getModel(){
//        return new UserDto();
//    }
//
//    @GetMapping("/{userId}")
//    public String profile(
//            @AuthenticationPrincipal UserDto currentUser,
//            @PathVariable(name = "userId") UserDto user,
//            Model model){
//        List<WallMessage> wallMessages = wallMessageRepository.findAll();
//        model.addAttribute("isCurrentUser", currentUser.equals(user));
//        model.addAttribute("posts", wallMessages);
////        model.addAttribute("userInfor", user);
//        return "main";
//    }
//
//    @PostMapping("/posts")
//    public String add(UserDto user,
//                      @ModelAttribute("post") WallMessageDto wallMessageDto,
//                      Model model){
//        wallMessageService.addPost(wallMessageDto, user);
//        List<WallMessage> wallMessages = wallMessageRepository.findAll();
//        model.addAttribute("posts", wallMessages);
//
//
//
//        return "main";
//    }




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



}
