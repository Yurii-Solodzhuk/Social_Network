package com.logos.social_network.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String photoURL;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "photo_likes",
            joinColumns = {@JoinColumn (name = "photo_id") },
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private List<User> likes = new ArrayList<>();

    private Boolean meLiked;

    private Integer likesCount;

    public Photo() {
    }
}
