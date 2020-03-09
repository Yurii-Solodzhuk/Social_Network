package com.logos.social_network.dto;

import com.logos.social_network.entity.Role;
import com.logos.social_network.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private Set<Role> role;
    private List<User> subscribers = new ArrayList<>();
    private List<User> subscription = new ArrayList<>();
//    private messages;
    private String avatarURL;
//    private List<String> photosURL;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String surname, String phoneNumber, String email, String password, String repeatPassword, Set<Role> role, List<User> subscribers, List<User> subscription, String avatarURL) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
        this.subscribers = subscribers;
        this.subscription = subscription;
        this.avatarURL = avatarURL;
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
