package com.logos.social_network.mapper;

import com.logos.social_network.dto.MessageDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.User;

import java.util.List;

public interface MessageMapper {
    List<MessageDto> toListDto(User user, Chat chatByID);
}
