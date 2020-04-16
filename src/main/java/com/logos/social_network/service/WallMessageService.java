package com.logos.social_network.service;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;

import java.util.List;

public interface WallMessageService {

    WallMessage save(WallMessage wallMessage);


    List<WallMessage> findAllMessagesOfCurrentUser(final Integer id);

    void addPost(User author, User recipient, String text);
    void like(User user, WallMessage wallMessage);
}
