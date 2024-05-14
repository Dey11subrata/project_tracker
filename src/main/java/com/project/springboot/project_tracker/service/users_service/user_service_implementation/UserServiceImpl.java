package com.project.springboot.project_tracker.service.users_service.user_service_implementation;

import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.repository.user_repository.UserRepository;
import com.project.springboot.project_tracker.service.users_service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    @Override
    public User createUser(User user) {
//write code to save user

        return userRepository.save(user);
    }

    @Override
    public List<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User>  searchUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    @Override
    public Optional<User> searchUserById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUser(int id, User user) {
        user.setUserId(id);
        return userRepository.save(user);
    }
}
