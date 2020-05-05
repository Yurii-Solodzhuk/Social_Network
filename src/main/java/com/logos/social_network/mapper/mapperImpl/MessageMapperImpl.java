package com.logos.social_network.mapper.mapperImpl;

import com.logos.social_network.dto.MessageDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.MessageMapper;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class MessageMapperImpl implements MessageMapper {

    private MessageDto toDto(User user, Chat chatByID, Message message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm ");
        MessageDto messageDto = new MessageDto();
        messageDto.setChatId(chatByID.getId());
        messageDto.setDate(formatter.format(message.getCreatedOn()));
        messageDto.setText(message.getText());
        messageDto.setOwnerId(message.getAuthor().getId());
        messageDto.setOwnerName(message.getAuthor().getName());
        messageDto.setRecipientId(user.getId());
        return messageDto;
    }

    public List<MessageDto> toListDto(User user, Chat chatByID) {
        List<MessageDto> messageDtos = new ArrayList<>();
        for (Message message : chatByID.getMessages()) {
            MessageDto messageDto = toDto(user, chatByID, message);
            messageDtos.add(messageDto);
        }
        return messageDtos;
    }

    public Message fromDto(MessageDto dto) {
        Message message = new Message();
        message.setText(dto.getText());
        return message;
    }
}
