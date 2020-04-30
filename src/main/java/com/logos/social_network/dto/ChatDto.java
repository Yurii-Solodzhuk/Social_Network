package com.logos.social_network.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatDto {
    private Integer id;
    private String text;
    private Integer authorId;
    private Integer recipientId;
}
