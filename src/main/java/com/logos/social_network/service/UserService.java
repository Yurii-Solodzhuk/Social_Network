package com.logos.social_network.service;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface UserService {
    void addAvatar(User user, MultipartFile file) throws IOException;
    User getUser(Integer id);
    User registration(UserDto userDto);
    User save(User user);
    void subscribe(User currentUser, User user);
    void unubscribe(User currentUser, User user);
    List<User> getAllUsers();
    boolean deleteUser(Integer userId);

}
