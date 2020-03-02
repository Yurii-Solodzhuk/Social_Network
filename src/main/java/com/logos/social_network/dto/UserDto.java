package com.logos.social_network.dto;

import com.logos.social_network.entity.Role;
import com.logos.social_network.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String surname;
//    private boolean gender;
    private String phoneNumber;
    private String email;
    private String password;
    private String repeatPassword;
    private Role role;
    private List<User> friendRequests = new ArrayList<>();
    private List<User> outcomingRequests = new ArrayList<>();
    private List<Integer> friendsIds = new ArrayList<>();
//    private messages;
    private String avatarURL;
    private List<String> photosURL;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String surname,  String phoneNumber, String email, String password, String repeatPassword, Role role, List<User> friendRequests, List<User> outcomingRequests, List<Integer> friendsIds, String avatarURL, List<String> photosURL) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
        this.friendRequests = friendRequests;
        this.outcomingRequests = outcomingRequests;
        this.friendsIds = friendsIds;
        this.avatarURL = avatarURL;
        this.photosURL = photosURL;
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
