//package com.logos.social_network.mapper;
//
//import com.logos.social_network.dto.ChatDto;
//import com.logos.social_network.dto.MessageDto;
//import com.logos.social_network.entity.Chat;
//import com.logos.social_network.entity.Message;
//import com.logos.social_network.entity.User;
//import org.springframework.stereotype.Component;
//
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//@Component
//public class ChatMapper {
//    public ChatDto toDto(User user, Chat chat){
//        return new ChatDto()
//                .setId(chat.getId())
//                .setRecipientId(user.getId())
//                .setRecipientName(user.getName());
//    }
//
//    public List<ChatDto> toListDto(User user, Chat chatByID) {
//        List<ChatDto> chatDtos = new ArrayList<>();
//        for (Chat chat : user.getChats()) {
//            ChatDto chatDto = toDto(user, chat);
//            chatDtos.add(chatDto);
//        }
//        return chatDtos;
//    }
//}
