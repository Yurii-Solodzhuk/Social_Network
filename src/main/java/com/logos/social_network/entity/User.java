package com.logos.social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "gender")
    private boolean gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "friend_requests")
    @ManyToMany(mappedBy = "outcomingRequests")
    private List<User> friendRequests = new ArrayList<>();

    @Column(name = "outcoming_requests")
    @ManyToMany
    private List<User> outcomingRequests = new ArrayList<>();

    @Column(name = "friends")
    @ElementCollection
    private List<Integer> friendsIds = new ArrayList<>();

//    private messages;

    @Column(name = "avatar_URL")
    private String avatarURL;

    @Column(name = "photos_URL")
    @ElementCollection
    private List<String> photosURL;

}
