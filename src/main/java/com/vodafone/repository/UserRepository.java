package com.vodafone.repository;

import com.vodafone.model.User;

import java.util.List;

public interface UserRepository {
    User addUser(User user);
    List<User> findAllUsers();
}
