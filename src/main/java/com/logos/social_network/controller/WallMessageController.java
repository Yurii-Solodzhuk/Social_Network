package com.logos.social_network.controller;

import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.service.UserService;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WallMessageController {

    @Autowired
    private WallMessageService wallMessageService;

    @Autowired
    private UserService userService;

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
        final User user = userService.getOne(id);
        model.addAttribute("posts", user.getReceivedPosts());
        model.addAttribute("user", user);
        return "main";
    }

    @PostMapping("/post")
    public String add(@ModelAttribute("post") WallMessageDto wallMessageDto,
                      Model model) {
        final User author = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final User recipient = userService.getOne(wallMessageDto.getRecipientId());

        wallMessageService.addPost(author, recipient, wallMessageDto.getText());
        List<WallMessage> wallMessages = wallMessageService.findAllMessagesOfCurrentUser(recipient.getId());
        model.addAttribute("posts", wallMessages);
        return "redirect:/" + recipient.getId();
    }
}
