package com.logos.social_network.mapper.mapperImpl;


import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.UserMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserMapperImpl implements UserMapper {
    @Autowired
    private ModelMapper mapper;

    @Override
    public UserDto toDto(User entity) {

//        UserDto userDto = new UserDto();
//        userDto.setId(userDto.getId());
//
//        return userDto;
        return Objects.isNull(entity) ? null : mapper.map(entity, UserDto.class);
    }

    @Override
    public User toEntity(UserDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, User.class);
    }

}
