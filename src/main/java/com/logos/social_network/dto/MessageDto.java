package com.logos.social_network.dto;

public class MessageDto {
    private Integer chatId;
    private String text;
    private String date;
    private Integer recipientId;
    private Integer ownerId;
    private String ownerName;
    private String imagePath;

    public String getText() {
        return text;
    }

    public MessageDto setText(String text) {
        this.text = text;
        return this;
    }

    public String getDate() {
        return date;
    }

    public MessageDto setDate(String date) {
        this.date = date;
        return this;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public MessageDto setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public MessageDto setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getChatId() {
        return chatId;
    }

    public MessageDto setChatId(Integer chatId) {
        this.chatId = chatId;
        return this;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public MessageDto setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
        return this;
    }
}
