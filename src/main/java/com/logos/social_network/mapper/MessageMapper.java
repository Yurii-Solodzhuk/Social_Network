package com.logos.social_network.mapper;

import com.logos.social_network.dto.MessageDto;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MessageMapper {

//    public static MessageDto toDto(Message message) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        User owner = message.getChat().getOwner();
//        return new MessageDto()
//                .setText(message.getText())
//                .setDate(formatter.format(message.getCreatedOn()))
//                .setOwnerId(Long.valueOf(owner.getId()))
//                .setOwnerName(owner.getName() + " " + owner.getSurname());
//    }
//
//    public static  List<MessageDto> toDtoList(List<Message> messages) {
//        List<MessageDto> messageDtos = new ArrayList<>();
//        for(Message message : messages){
//            messageDtos.add(toDto(message));
//        }
//        return messageDtos;
//    }
}
