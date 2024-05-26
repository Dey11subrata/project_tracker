package com.project.springboot.project_tracker.controller.user_controller;

import com.project.springboot.project_tracker.dto.user_dto.UserDto;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.service.users_service.UserService;
import com.project.springboot.project_tracker.utility.mapper.UserMapper;
import com.project.springboot.project_tracker.utility.response.Response;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/register_user")
    public User registerUser(@Valid @RequestBody UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        return userService.createUser(user);
//        returning in this manner exposes all the user related fields
    }

    @GetMapping("/list_all_users")
    public List<User> listAllUser() {
        log.info("incoming request- list");
        return userService.listAllUsers();
    }

    @GetMapping("/search")
    public User searchUser(@RequestParam(name = "email", required = false) String userEmail,
                                 @RequestParam(name = "id", required = false) String userId,
                                 @RequestParam(name = "firstname", required = false) String userFirstName,
                                 @RequestParam(name = "lastname", required = false) String userLastName) {
        log.info("incoming request");
//        log.info(userEmail);

      Optional<User> searchedUser = userEmail != null && !userEmail.trim().isEmpty() ?
                userService.searchUserByEmail(userEmail.trim()) :
                (userId != null && !userId.trim().isEmpty() ?
                        userService.searchUserById(Integer.parseInt(userId.trim())) : Optional.empty());

        if(searchedUser.isEmpty()){
                // if a user is not found by email or id
            // then allow to perform search by name

            throw new RuntimeException("not a valid user");
        }

        return searchedUser.get();

    }
/*
@PutMapping("/update/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable(name = "id") int userId, @RequestBody UserDto userDto){
        Response response = new Response();

        Optional<User> userSearchedById = userService.searchUserById(userId);
        if(userSearchedById.isPresent()){
            User userWithUpdatedDetails = userSearchedById.get();
            userMapper.updateUserFromDto(userDto, userWithUpdatedDetails);
log.info(userSearchedById.get().getUserFirstName());
           User updatedUser = userService.updateUser(userId, userWithUpdatedDetails);
           log.info(updatedUser.getUserFirstName());
           if(updatedUser!=null){
               response.setMessage("User updated successfully");
               response.setStatus(HttpStatus.ACCEPTED.value());
           }
        }
        return ResponseEntity.status(HttpStatus.OK)
                .header("user_updated", "true")
                .body(response);
    }
*/


}
