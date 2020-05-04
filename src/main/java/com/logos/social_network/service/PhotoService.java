package com.logos.social_network.service;

import com.logos.social_network.entity.Photo;
import com.logos.social_network.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;

public interface PhotoService {
    void uploadPhoto(User user, MultipartFile file) throws IOException;
    void like(User user, Photo photo);
}
