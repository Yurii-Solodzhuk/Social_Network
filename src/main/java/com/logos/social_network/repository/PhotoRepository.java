package com.logos.social_network.repository;

import com.logos.social_network.entity.Photo;
import com.logos.social_network.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> {
    List<Photo> findAllByUser(User user);
}
