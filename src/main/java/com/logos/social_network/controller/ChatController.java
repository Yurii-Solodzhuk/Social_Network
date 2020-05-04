package com.logos.social_network.controller;

import com.logos.social_network.dto.ChatDto;
import com.logos.social_network.dto.MessageDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.MessageMapper;
import com.logos.social_network.service.ChatService;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @Autowired
    private UserService userService;
    @Autowired
    private MessageMapper messageMapper;

    @ModelAttribute("chat")
    public ChatDto getModel(){
        return new ChatDto();
    }

    @GetMapping
    public String chats(@AuthenticationPrincipal User currentUser, Model model) {
        User user = userService.getUser(currentUser.getId());
        List<ChatDto> chats = toChatDtoList(user);
        model.addAttribute("chats", chats);
        return "chats";
    }

    private List<ChatDto> toChatDtoList(User user) {
        return user.getChats()
                .stream()
                .map(chat -> toChatDto(chat, user.getId()))
                .collect(Collectors.toList());
    }

    private ChatDto toChatDto(Chat chat, Integer id) {
        Message lastMessage = getLastMessage(chat);
        User user = getAnotherUser(chat, id);
        return new ChatDto()
                .setLastMessage(lastMessage.getText())
                .setLastMessageDate(lastMessage.getCreatedOn().toString())
                .setRecipientId(user.getId())
                .setRecipientName(user.getName());
    }

    private User getAnotherUser(Chat chat, Integer id) {
        return chat.getMembers()
                .stream()
                .filter(x -> !x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Message getLastMessage(Chat chat) {
        List<Message> messages = chat.getMessages();
        messages.sort(comparing(Message::getCreatedOn).reversed());
        return messages.isEmpty() ? null : messages.get(0);
    }

    @GetMapping("/{userId}")
    public String messages(@AuthenticationPrincipal User currentUser,
                           @PathVariable Integer userId,
                           Model model) {
        User user = userService.getUser(userId);
        User user1 = userService.getUser(currentUser.getId());
        Integer chatId = chatService.getChat(user1, user);
        Chat chatByID = chatService.chatById(chatId);
        List<MessageDto> messageDtos = messageMapper.toListDto(user, chatByID);
        messageDtos.sort(comparing(MessageDto::getDate).reversed());
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