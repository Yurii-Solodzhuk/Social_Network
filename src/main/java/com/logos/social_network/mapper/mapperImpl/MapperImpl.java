package com.logos.social_network.mapper.mapperImpl;


import com.logos.social_network.dto.UserDto;
import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MapperImpl implements Mapper {
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






    @Override
    public WallMessageDto toDto(WallMessage entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, WallMessageDto.class);
    }

    @Override
    public WallMessage toEntity(WallMessageDto dto) {
        return Objects.isNull(dto) ? null : mapper.map(dto, WallMessage.class);
    }

}
