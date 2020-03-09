package com.logos.social_network.service.userServiceImpl;

import com.logos.social_network.dto.UserDto;
import com.logos.social_network.entity.Role;
import com.logos.social_network.entity.User;
import com.logos.social_network.repository.UserRepository;
import com.logos.social_network.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service()
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

//    @Override
//    public void addAvatar(String avararURL) {
//        BufferedImage image = null;
//        try {
//            File inputFile = new File(avararURL);
//            image = ImageIO.read(inputFile);
//            ImageIO.write(image, "png", inputFile); //change outputFile
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public User getOne(Integer id){
        return userRepository.findUserById(id);
    }

    @Override
    public User registration(UserDto userDto) {
        if (!isRegistrationValide(userDto)) throw new AccessDeniedException("Bad data");

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRole(Collections.singleton(Role.USER));
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
        if (!user.getSubscribers().contains(currentUser)){
            user.getSubscribers().add(currentUser);
            userRepository.save(user);
        }
    }

    @Override
    public void unubscribe(User currentUser, User user) {
        if (user.getSubscribers().contains(currentUser)){
            user.getSubscribers().remove(currentUser);
            userRepository.save(user);
        }
    }

    private Boolean isRegistrationValide(UserDto userDto){
        if (!userDto.getEmail().contains("@"))return false;
        if (!userDto.getPassword().equals(userDto.getRepeatPassword()))return false;
        if (userDto.getPhoneNumber().length() != 10)return false;
        if (userRepository.countByEmailAndPhoneNumber(userDto.getEmail(), userDto.getPhoneNumber()) > 0)return false;
        return true;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email);
    }
}

