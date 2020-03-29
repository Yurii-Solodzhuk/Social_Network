package com.logos.social_network.controller;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.UserMapper;
import com.logos.social_network.service.UserService;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProfileController {


    @Autowired
    private WallMessageService wallMessageService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;


    @ModelAttribute("user")
    public UserDto model() {
        return new UserDto();
    }

    @ModelAttribute("post")
    public WallMessageDto getModel() {
        return new WallMessageDto();
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        final User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return getUserInfo(author.getId(), model);
    }

    @GetMapping("/{id}")
    public String posts(@PathVariable Integer id, Model model) {
        return getUserInfo(id, model);
    }

    private String getUserInfo(Integer id, Model model) {
        final User user = userService.getUser(id);
        model.addAttribute("posts", user.getReceivedPosts());
        model.addAttribute("user", user);
        return "profile";
    }

    @PostMapping("/post")
    public String add(@ModelAttribute("post") WallMessageDto wallMessageDto,
                      Model model) {
        final User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final User recipient = userService.getUser(wallMessageDto.getRecipientId());

        wallMessageService.addPost(author, recipient, wallMessageDto.getText());
//        List<WallMessage> wallMessages = wallMessageService.findAllMessagesOfCurrentUser(recipient.getId());
//        model.addAttribute("posts", wallMessages);
        return "redirect:/" + recipient.getId();
    }

    @PostMapping("/upload")
    public String upload(@RequestParam(name = "file") MultipartFile multipartFile) throws IOException {
        final User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDto userDto = userMapper.toDto(user);
        userService.addAvatar(userDto,multipartFile);

        return "redirect:/";
    }


}
