package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.Photo;
import com.logos.social_network.entity.Role;
import com.logos.social_network.entity.User;
import com.logos.social_network.mapper.Mapper;
import com.logos.social_network.repository.UserRepository;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;


@Service()
public class UserServiceImpl implements UserService, UserDetailsService {

    @Value("${upload.path}")
    private String uploadPath;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private Mapper mapper;


    public User getUser(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User registration(UserDto userDto) {
        if (!isRegistrationValide(userDto)) throw new AccessDeniedException("Bad data");

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(encoder.encode(userDto.getPassword()));
        if (userDto.getPassword().equals("admin")) user.setRole(Collections.singleton(Role.ADMIN));
        else user.setRole(Collections.singleton(Role.USER));
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());

        return save(user);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void subscribe(User currentUser, User user) {
        if (!user.getSubscribers().contains(currentUser)) {
            user.getSubscribers().add(currentUser);
            userRepository.save(user);
        }
    }

    @Override
    public void unubscribe(User currentUser, User user) {
        if (user.getSubscribers().contains(currentUser)) {
            user.getSubscribers().remove(currentUser);
            userRepository.save(user);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteUser(Integer userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }


    private Boolean isRegistrationValide(UserDto userDto) {
        if (!userDto.getEmail().contains("@")) return false;
        if (!userDto.getPassword().equals(userDto.getRepeatPassword())) return false;
        if (userDto.getPhoneNumber().length() != 10) return false;
        if (userRepository.countByEmailAndPhoneNumber(userDto.getEmail(), userDto.getPhoneNumber()) > 0) return false;
        return true;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }


    @Override
    public void addAvatar(User user, MultipartFile file) throws IOException {

        if (file != null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));

            user.setAvatarURL(resultFileName);
//            User user = userMapper.toEntity(userDto);
            userRepository.save(user);
        }
    }

}

