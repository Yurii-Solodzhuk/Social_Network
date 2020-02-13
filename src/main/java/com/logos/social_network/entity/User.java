package com.logos.social_network.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "social_network")
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

//    @Column(name = "friends")
//    private List<User> friends = new ArrayList<>();

//    private messages;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "photos")
    private List<String> photos;

}
