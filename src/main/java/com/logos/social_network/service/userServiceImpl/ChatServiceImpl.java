package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.dao.ChatDAO;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;
import com.logos.social_network.repository.ChatRepository;
import com.logos.social_network.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ChatDAO chatDAO;


    private Chat newChat(User author, User recipient) {
        List<User> members = new ArrayList<>();
        members.add(author);
        members.add(recipient);
        Chat chat = new Chat(members);
        author.setChats(Arrays.asList(chat));
        recipient.setChats(Arrays.asList(chat));
        return chatRepository.save(chat);
    }

    @Override
    public Integer getChat(User author, User recipient) {
        Integer chatId =  chatDAO.findChatIdByMemberIds(author.getId(), recipient.getId());
        if (Objects.isNull(chatId)) {
            return newChat(author, recipient).getId();
        }
        return chatId;
    }

    private void newMessage(User author, User recipient, Chat chat, String text) {
        Message message = new Message(text, LocalDateTime.now(), author, recipient);
        chat.getMessages().add(message);
        message.setChat(chat);
        chatRepository.save(chat);
    }

    @Override
    public Chat chatById(Integer chatId) {
        return chatRepository.findChatById(chatId);
    }

    @Override
    public void sentMessage(Chat chat, User author, User recipient, String text) {
        newMessage(author, recipient, chat, text);
        chatRepository.save(chat);
    }

}
