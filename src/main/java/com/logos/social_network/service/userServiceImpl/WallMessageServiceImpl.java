package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import com.logos.social_network.repository.WallMessageRepository;
import com.logos.social_network.service.WallMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallMessageServiceImpl implements WallMessageService {
    @Autowired
    private WallMessageRepository wallMessageRepository;

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
}


