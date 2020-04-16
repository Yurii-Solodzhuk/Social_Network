package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.entity.Photo;
import com.logos.social_network.entity.User;
import com.logos.social_network.repository.PhotoRepository;
import com.logos.social_network.repository.UserRepository;
import com.logos.social_network.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public void uploadPhoto(User user, MultipartFile file) throws IOException {
        Photo photo = new Photo();
        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));
            photo.setPhotoURL(resultFileName);
            photo.setUser(user);
            photoRepository.save(photo);
        }
    }
}
