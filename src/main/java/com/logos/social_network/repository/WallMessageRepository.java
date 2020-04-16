package com.logos.social_network.repository;

import com.logos.social_network.entity.WallMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WallMessageRepository extends JpaRepository<WallMessage, Integer> {

    List<WallMessage> findAllByAuthorId(final Integer id);
}
