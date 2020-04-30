package com.logos.social_network.repository;

import com.logos.social_network.entity.Chat;
import com.logos.social_network.entity.Message;
import com.logos.social_network.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Chat findChatById(Integer chatId);
}
