package com.project.springboot.project_tracker.controller.user_controller;

import com.project.springboot.project_tracker.dto.user_dto.UserDto;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.service.users_service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/create-user")
    public User createUser(@RequestBody UserDto userDto){
        User user = modelMapper.map(userDto, User.class);
        return userService.createUser(user);
    }

    @GetMapping("/list-all-users")
    public List<User> listAllUser(){
return userService.listAllUsers();
    }



}
