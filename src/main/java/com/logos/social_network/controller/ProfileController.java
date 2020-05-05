package com.logos.social_network.controller;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.Photo;
import com.logos.social_network.entity.User;
import com.logos.social_network.service.PhotoService;
import com.logos.social_network.service.UserService;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private WallMessageService wallMessageService;
    @Autowired
    private UserService userService;
    @Autowired
    private PhotoService photoService;


    @ModelAttribute("user")
    public UserDto model() {
        return new UserDto();
    }

    @ModelAttribute("post")
    public WallMessageDto getModel() {
        return new WallMessageDto();
    }

    @GetMapping("/")
    public String getMainPage(@AuthenticationPrincipal User currentUser, Model model) {
        User user = userService.getUser(currentUser.getId());
        return getUserInfo(user.getId(), model);
    }

    @GetMapping("/{id}")
    public String posts(@PathVariable Integer id, Model model) {
        return getUserInfo(id, model);
    }

    private String getUserInfo(Integer id, Model model) {
        final User user = userService.getUser(id);
        final User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("posts", user.getReceivedPosts());
        model.addAttribute("user", user);
        model.addAttribute("subscriptionsCount", user.getSubscription().size());
        model.addAttribute("subscribersCount", user.getSubscribers().size());
        model.addAttribute("isCurrentUser", currentUser.equals(user));
        model.addAttribute("isSubcriber", user.getSubscribers().contains(currentUser));
        model.addAttribute("isAdmin", user.isAdmin());
        model.addAttribute("currentUser", currentUser);
        List<Photo> photos = user.getPhotos();
        if (photos.size() > 7) {
            List<Photo> photo = user.getPhotos().subList(0, 7);
            model.addAttribute("photos", photo);
        } else {
            model.addAttribute("photos", photos);
        }
        return "profile";
    }

    @PostMapping("/post")
    public String add(@ModelAttribute("post") WallMessageDto wallMessageDto,
                      @AuthenticationPrincipal User currentUser) {
        User author = userService.getUser(currentUser.getId());
        User recipient = userService.getUser(wallMessageDto.getRecipientId());
        wallMessageService.addPost(author, recipient, wallMessageDto.getText());
        return "redirect:/" + recipient.getId();
    }

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam(name = "photos") MultipartFile multipartFile,
                              @AuthenticationPrincipal User currentUser) throws IOException {
        User user = userService.getUser(currentUser.getId());
        photoService.uploadPhoto(user, multipartFile);
        return "redirect:/";
    }

    @GetMapping("{user}/{photo}/islike")
    public String likes(@AuthenticationPrincipal User currnetUser,
                        @PathVariable Photo photo,
                        @PathVariable User user) {
        photoService.like(currnetUser, photo);
        return "redirect:/" + user.getId();
    }

}
