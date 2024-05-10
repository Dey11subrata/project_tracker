package com.project.springboot.project_tracker.service.users_service;

import com.project.springboot.project_tracker.model.users.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> listAllUsers();
}
