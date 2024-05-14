package com.project.springboot.project_tracker.service.users_service;

import com.project.springboot.project_tracker.model.users.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);

    List<User> listAllUsers();

    Optional<User>  searchUserByEmail(String trim);

    Optional<User> searchUserById(int i);

    User updateUser(int id, User user);
}
