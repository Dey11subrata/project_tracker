package com.project.springboot.project_tracker.controller.user_controller;

import com.project.springboot.project_tracker.dto.user_dto.UserDto;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.service.users_service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("/register_user")
    public User registerUser(@RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userService.createUser(user);
//        returning in this manner exposes all the user related fields
    }

    @GetMapping("/list_all_users")
    public List<User> listAllUser() {
        return userService.listAllUsers();
    }

    @GetMapping("/")
    public User updateUserDetail(@RequestParam(name = "email", required = false) String userEmail,
                                 @RequestParam(name = "id", required = false) String userId,
                                 @RequestParam(name = "firstname", required = false) String userFirstName,
                                 @RequestParam(name = "lastname", required = false) String userLastName) {

      Optional<User> searchedUser = userEmail != null && !userEmail.trim().isEmpty() ?
                userService.searchUserByEmail(userEmail.trim()) :
                (userId != null && !userId.trim().isEmpty() ?
                        userService.searchUserById(Integer.parseInt(userId.trim())) : Optional.empty());

        if(searchedUser.isEmpty()){

            throw new RuntimeException("not a valid user");
        }

        return searchedUser.get();

    }


}
