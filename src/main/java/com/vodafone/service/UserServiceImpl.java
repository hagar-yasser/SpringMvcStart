package com.vodafone.service;

import com.vodafone.model.User;
import com.vodafone.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
       return userRepository.addUser(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAllUsers();
    }
}
