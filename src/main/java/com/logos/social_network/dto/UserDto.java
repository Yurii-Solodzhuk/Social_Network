package com.logos.social_network.dto;

import com.logos.social_network.entity.Role;
import com.logos.social_network.entity.User;
import com.logos.social_network.entity.WallMessage;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
public class UserDto {

    private Integer id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String password;
    private String repeatPassword;
    private Set<Role> role;
    private List<User> subscribers = new ArrayList<>();
    private List<User> subscription = new ArrayList<>();
    private List<WallMessage> posts;
    private String avatarURL;
    private String city;
    private String work;
    private String bithday;
    private String info;

    public UserDto() {
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


}
