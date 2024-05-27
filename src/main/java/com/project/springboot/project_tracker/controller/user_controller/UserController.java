package com.project.springboot.project_tracker.controller.user_controller;

import com.project.springboot.project_tracker.dto.user_dto.UpdateUserDto;
import com.project.springboot.project_tracker.dto.user_dto.UserDto;
import com.project.springboot.project_tracker.dto.user_dto.UserWithUpdatedDetails;
import com.project.springboot.project_tracker.exceptions.NoSuchUserFound;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.response.UserUpdate;
import com.project.springboot.project_tracker.service.users_service.UserService;
import com.project.springboot.project_tracker.utility.mapper.UserMapper;
import com.project.springboot.project_tracker.utility.response.Response;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    private final UserService userService;

    private final ModelMapper modelMapper;
    @Autowired(required = true)
    private UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/update")
    public ResponseEntity<UserUpdate> updateUser(@RequestBody UserWithUpdatedDetails userWithUpdatedDetails){
        // find user by id
        log.info(SecurityContextHolder.getContext().getAuthentication().getName());

        Optional<User> user = userService.searchUserById(userWithUpdatedDetails.getId());
        if(user.isPresent() && SecurityContextHolder.getContext().getAuthentication().getName().equals(user.get().getUsername() )){
            userWithUpdatedDetails.setUpdatedAt(LocalDate.now());
            modelMapper.map(userWithUpdatedDetails, user.get());

            userService.updateUser(userWithUpdatedDetails.getId(), user.get());

            UserUpdate userUpdate = new UserUpdate();
            userUpdate.setMessage("user updated Successfully");
            userUpdate.setUpdateUserDto(modelMapper.map(user.get(), UpdateUserDto.class));
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(userUpdate);
        }
        else
            throw new NoSuchUserFound("corresponding user not found");
    }



}
