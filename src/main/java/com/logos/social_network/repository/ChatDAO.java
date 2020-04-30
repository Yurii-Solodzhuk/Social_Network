package com.logos.social_network.repository;

public interface ChatDAO {
    Integer findChatIdByMemberIds(Integer firstId, Integer secondId);
}
