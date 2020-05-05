package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.repository.WallMessageRepository;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("wallMessageService")
public class WallMessageServiceImpl implements WallMessageService {
    @Autowired
    private WallMessageRepository wallMessageRepository;


    @Override
    public void addPost(User author, User recipient, String text) {
        WallMessage wallMessage = new WallMessage();
        wallMessage.setText(text);
        wallMessage.setAuthor(author);
        wallMessage.setRecipient(recipient);
        wallMessageRepository.save(wallMessage);
    }


    @Override
    public void like(User user, WallMessage wallMessage) {
        List<User> likes = wallMessage.getLikes();

        if (likes.contains(user)){
            likes.remove(user);
            wallMessage.setMeLiked(false);
        }else {
            likes.add(user);
            wallMessage.setMeLiked(true);
        }
        wallMessage.setLikesCount(wallMessage.getLikes().size());

        wallMessageRepository.save(wallMessage);
    }
}


