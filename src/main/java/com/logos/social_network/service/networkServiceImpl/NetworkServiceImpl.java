package com.logos.social_network.service.networkServiceImpl;

import com.logos.social_network.entity.User;
import com.logos.social_network.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;


@Service
public class NetworkServiceImpl implements com.logos.social_network.service.NetworkService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> addToFriends(User user) {
        List<User> friendRequests = user.getFriendRequests();
        if (!friendRequests.contains(user)) {
            user.getFriendRequests().add(user);
        } else {
            System.out.println("You have been having friend with " + user.getName());
        }
        return user.getFriendRequests();
    }

    @Override
    public void acceptFriend(User user) {
        List<User> friendRequests = user.getFriendRequests();
        List<User> friends = user.getFriends();
        if (!friends.contains(user)&&friendRequests.contains(user)){
            user.getFriends().add(userRepository.save(user));// update myself
//            userRepository.save(user);
        }

    }

    @Override
    public void addAvatar(String avararURL) {
        BufferedImage image = null;
        try {
            File inputFile = new File(avararURL);
            image = ImageIO.read(inputFile);
            ImageIO.write(image, "png", inputFile); //change outputFile
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

