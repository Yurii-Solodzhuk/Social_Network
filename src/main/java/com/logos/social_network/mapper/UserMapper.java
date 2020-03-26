package com.logos.social_network.mapper;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.User;

public interface UserMapper {

    UserDto toDto(User entity);

    User toEntity(UserDto dto);
}
