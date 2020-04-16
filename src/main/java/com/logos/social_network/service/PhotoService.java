package com.logos.social_network.service;

import com.logos.social_network.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    void uploadPhoto(User user, MultipartFile file) throws IOException;

}
