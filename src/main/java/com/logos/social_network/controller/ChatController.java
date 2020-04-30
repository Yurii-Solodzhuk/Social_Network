package com.logos.social_network.controller;

import com.logos.social_network.dto.ChatDto;
import com.logos.social_network.dto.MessageDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;
import com.logos.social_network.service.ChatService;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;

    @ModelAttribute("chat")
    public ChatDto getModel(){
        return new ChatDto();
    }

    @GetMapping
    public String messages(@AuthenticationPrincipal User user, Model model) {
        List<Chat> chats = userService.getUser(user.getId()).getChats();
        model.addAttribute("chats", chats);
        return "chats";
    }

    @GetMapping("/{userId}")
    public String chat(@AuthenticationPrincipal User currentUser,
                       @PathVariable Integer userId,
                       Model model) {
        User user = userService.getUser(userId);
        Integer chatId = chatService.getChat(currentUser, user);
        Chat chatByID = chatService.getChatByID(chatId);

        List<MessageDto> messageDtos = toListDto(user, chatByID);

        messageDtos.sort(comparing(MessageDto::getDate).reversed());

        model.addAttribute("messages", messageDtos);
        model.addAttribute("chatId", chatId);
        model.addAttribute("id", user.getId());
        return "chat";
    }

    private List<MessageDto> toListDto(User user, Chat chatByID) {
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message message : chatByID.getMessages()) {
            MessageDto messageDto = toDto(user, chatByID, message);
            messageDtos.add(messageDto);
        }
        return messageDtos;
    }

    private MessageDto toDto(User user, Chat chatByID, Message message) {
        MessageDto messageDto = new MessageDto();
        messageDto.setChatId(chatByID.getId());
        messageDto.setDate(String.valueOf(message.getCreatedOn()));
        messageDto.setText(message.getText());
        messageDto.setOwnerId(message.getAuthor().getId());
        messageDto.setOwnerName(message.getAuthor().getName());
        messageDto.setRecipientId(user.getId());
        return messageDto;
    }

    private Message fromDto(MessageDto dto) {
        Message message = new Message();
        message.setText(dto.getText());
        return message;
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