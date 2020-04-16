package com.logos.social_network.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class WallMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient_id")
    private User recipient;

    @ManyToMany
    @JoinTable(name = "post_likes",
            joinColumns = {@JoinColumn (name = "post_id") },
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> likes = new ArrayList<>();

    private Boolean meLiked;
    private Integer likesCount;



    public WallMessage() {
    }
}
