package com.logos.social_network.mapper;

import com.logos.social_network.dto.ChatDto;
import com.logos.social_network.entity.User;

import java.util.List;

public interface ChatMapper {
    List<ChatDto> toChatDtoList(User user);
}
