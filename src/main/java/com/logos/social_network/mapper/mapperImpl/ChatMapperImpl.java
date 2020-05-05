package com.logos.social_network.mapper.mapperImpl;

import com.logos.social_network.dto.ChatDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.ChatMapper;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Component
public class ChatMapperImpl implements ChatMapper {
    public List<ChatDto> toChatDtoList(User user) {
        return user.getChats()
                .stream()
                .map(chat -> toChatDto(chat, user.getId()))
                .collect(Collectors.toList());
    }

    private ChatDto toChatDto(Chat chat, Integer id) {
        Message lastMessage = getLastMessage(chat);
        User user = getAnotherUser(chat, id);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm ");
        return new ChatDto()
                .setLastMessage(lastMessage.getText())
                .setLastMessageDate(formatter.format(lastMessage.getCreatedOn()))
                .setRecipientId(user.getId())
                .setRecipientName(user.getName() + " " + user.getSurname());
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
}
