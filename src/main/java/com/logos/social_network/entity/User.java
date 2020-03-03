package com.logos.social_network.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

//    @Column(name = "gender")
//    private boolean gender;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

//    @Column(name = "friend_requests")
//    @ManyToMany(mappedBy = "outcomingRequests", fetch = FetchType.LAZY)
//    private List<User> friendRequests = new ArrayList<>();
//
//    @Column(name = "outcoming_requests")
//    @ManyToMany
//    private List<User> outcomingRequests = new ArrayList<>();
//
//    @Column(name = "friends")
//    @ElementCollection
//    private List<Integer> friendsIds = new ArrayList<>();

//    private messages;

    @Column(name = "avatar_URL")
    private String avatarURL;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

//    @Column(name = "photos_URL")
//    @ElementCollection
//    private List<String> photosURL;

}
