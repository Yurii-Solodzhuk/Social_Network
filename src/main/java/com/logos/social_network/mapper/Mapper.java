package com.logos.social_network.mapper;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;

public interface Mapper {

    UserDto toDto(User entity);
    User toEntity(UserDto dto);

    WallMessageDto toDto(WallMessage entity);
    WallMessage toEntity(WallMessageDto dto);
}
