package com.logos.social_network.service;

import com.logos.social_network.entity.User;

import java.io.IOException;


public interface NetworkService {
    User addToFriends(User user);
    void acceptFriend(User user);
    void addAvatar(String avararURL);
}
