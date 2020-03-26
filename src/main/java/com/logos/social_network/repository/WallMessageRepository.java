package com.logos.social_network.repository;

import com.logos.social_network.entity.WallMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WallMessageRepository extends JpaRepository<WallMessage, Integer> {

    List<WallMessage> findAllByAuthorId(final Integer id);
}
