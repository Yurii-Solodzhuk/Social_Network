package com.logos.social_network.service;

import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.User;


public interface ChatService {
    Integer getChat(User author, User recipient);
    Chat chatById(Integer chatId);
    void sentMessage(Chat chat, User author, User recipient, String text);
}
