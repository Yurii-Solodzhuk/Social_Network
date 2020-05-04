package com.logos.social_network.dao;

public interface ChatDAO {
    Integer findChatIdByMemberIds(Integer firstId, Integer secondId);
}
