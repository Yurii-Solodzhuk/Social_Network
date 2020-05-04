package com.logos.social_network.dto;

public class ChatDto {
    private String lastMessage;
    private Integer recipientId;
    private String recipientName;
    private String lastMessageDate;

    public String getText() {
        return lastMessage;
    }

    public ChatDto setText(String lastMessage) {
        this.lastMessage = lastMessage;
        return this;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public ChatDto setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
        return this;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public ChatDto setRecipientName(String recipientName) {
        this.recipientName = recipientName;
        return this;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public ChatDto setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
        return this;
    }

    public String getLastMessageDate() {
        return lastMessageDate;
    }

    public ChatDto setLastMessageDate(String lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
        return this;
    }
}
