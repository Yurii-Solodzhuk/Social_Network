package com.logos.social_network.service;

import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;

public interface WallMessageService {
    void addPost(User author, User recipient, String text);
    void like(User user, WallMessage wallMessage);
}
