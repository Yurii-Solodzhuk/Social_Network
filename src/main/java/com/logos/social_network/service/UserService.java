package com.logos.social_network.service;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.User;

import java.io.IOException;
import java.util.List;


public interface UserService {
//    void addAvatar(String avararURL);
    User getOne(Integer id);
    User registration(UserDto userDto);
    User save(User user);
    void subscribe(User currentUser, User user);
    void unubscribe(User currentUser, User user);

}
