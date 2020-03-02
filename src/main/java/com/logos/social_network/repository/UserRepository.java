package com.logos.social_network.repository;

import com.logos.social_network.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
    Integer countByEmailAndPhoneNumber(String email, String phoneNumber);
    User findByEmail(String email);
}
