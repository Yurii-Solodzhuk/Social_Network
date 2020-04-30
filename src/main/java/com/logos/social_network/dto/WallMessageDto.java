package com.logos.social_network.dto;

import com.logos.social_network.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class WallMessageDto {
    private Integer id;
    private String text;
    private Integer authorId;
    private Integer recipientId;
    private Integer likesCount;
    private Boolean meLiked;
    private List<User> likes = new ArrayList<>();

    public WallMessageDto() {
    }





}
