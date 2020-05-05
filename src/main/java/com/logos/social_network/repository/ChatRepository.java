package com.logos.social_network.repository;

import com.logos.social_network.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    Chat findChatById(Integer chatId);
}
