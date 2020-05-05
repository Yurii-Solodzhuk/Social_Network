package com.logos.social_network.controller;

import com.logos.social_network.dto.ChatDto;
import com.logos.social_network.dto.MessageDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.ChatMapper;
import com.logos.social_network.mapper.mapperImpl.MessageMapperImpl;
import com.logos.social_network.service.ChatService;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Comparator.comparing;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageMapperImpl messageMapper;
    @Autowired
    private ChatMapper chatMapper;

    @ModelAttribute("chat")
    public ChatDto getModel(){
        return new ChatDto();
    }

    @GetMapping
    public String chats(@AuthenticationPrincipal User currentUser, Model model) {
        User user = userService.getUser(currentUser.getId());
        List<ChatDto> chats = chatMapper.toChatDtoList(user);
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("chats", chats);
        return "chats";
    }

    @GetMapping("/{userId}")
    public String messages(@AuthenticationPrincipal User currentUser,
                           @PathVariable Integer userId,
                           Model model) {
        User curUser = userService.getUser(currentUser.getId());
        User user = userService.getUser(userId);
        Integer chatId = chatService.getChat(curUser, user);
        Chat chatByID = chatService.chatById(chatId);
        List<MessageDto> messageDtos = messageMapper.toListDto(user, chatByID);
        messageDtos.sort(comparing(MessageDto::getDate).reversed());
        model.addAttribute("currentUser", currentUser);
        model.addAttribute("messages", messageDtos);
        model.addAttribute("chatId", chatId);
        model.addAttribute("id", user.getId());
        return "chat";
    }


    @PostMapping("/{chatId}/{userId}/message")
    public String message(@AuthenticationPrincipal User currentUser,
                          @RequestParam String message,
                          @PathVariable Integer chatId,
                          @PathVariable Integer userId) {
        final User user = userService.getUser(userId);
        Chat chat = chatService.chatById(chatId);
        chatService.sentMessage(chat, currentUser, user, message);
        return "redirect:/chats/" + user.getId();
    }
}