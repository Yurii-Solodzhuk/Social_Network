package com.logos.social_network.dto;

import com.logos.social_network.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallMessageDto {
    private Integer id;
    private String text;
    private Integer authorId;
    private Integer recipientId;

    public WallMessageDto() {
    }

    public WallMessageDto(String text, Integer authorId) {
        this.text = text;
        this.authorId = authorId;
    }
}
