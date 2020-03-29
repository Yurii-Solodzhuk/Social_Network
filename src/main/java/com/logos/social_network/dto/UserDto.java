package com.logos.social_network.dto;

import com.logos.social_network.entity.Role;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
    private List<WallMessage> posts;
    private String avatarURL;
//    private List<String> photosURL;

    public UserDto() {
    }

    public UserDto(Integer id, String name, String surname, String phoneNumber, String email, String password, String repeatPassword, Set<Role> role, List<User> subscribers, List<User> subscription, List<WallMessage> posts, String avatarURL) {
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
        this.posts = posts;
        this.avatarURL = avatarURL;
    }

    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return id.equals(userDto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public List<User> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<User> subscribers) {
        this.subscribers = subscribers;
    }

    public List<User> getSubscription() {
        return subscription;
    }

    public void setSubscription(List<User> subscription) {
        this.subscription = subscription;
    }

    public List<WallMessage> getPosts() {
        return posts;
    }

    public void setPosts(List<WallMessage> posts) {
        this.posts = posts;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

}
