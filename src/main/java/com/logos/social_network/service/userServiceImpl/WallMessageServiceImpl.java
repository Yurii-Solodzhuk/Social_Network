package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.dto.WallMessageDto;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.mapper.Mapper;
import com.logos.social_network.repository.WallMessageRepository;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallMessageServiceImpl implements WallMessageService {
    @Autowired
    private WallMessageRepository wallMessageRepository;
    @Autowired
    private Mapper mapper;

    @Override
    public WallMessage save(WallMessage wallMessage) {
        return wallMessageRepository.save(wallMessage);
    }


    @Override
    public List<WallMessage> findAllMessagesOfCurrentUser(Integer id) {
        return wallMessageRepository.findAllByAuthorId(id);
    }

    @Override
    public void addPost(User author, User recipient, String text) {
        wallMessageRepository.save(toEntity(author, recipient, text));
    }



    private WallMessage toEntity(User author, User recipient, String text) {
        WallMessage wallMessage = new WallMessage();
        wallMessage.setText(text);
        wallMessage.setAuthor(author);
        wallMessage.setRecipient(recipient);
        return wallMessage;
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


