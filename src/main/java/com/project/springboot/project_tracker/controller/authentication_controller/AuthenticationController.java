package com.project.springboot.project_tracker.controller.authentication_controller;

import com.project.springboot.project_tracker.constants.RoleEnum;
import com.project.springboot.project_tracker.dto.user_dto.LoginUserDto;
import com.project.springboot.project_tracker.dto.user_dto.RegisterUserDto;
import com.project.springboot.project_tracker.model.users.Role;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.repository.user_repository.RoleRepository;
import com.project.springboot.project_tracker.response.LoginResponse;
import com.project.springboot.project_tracker.service.authentication_service.AuthenticationService;
import com.project.springboot.project_tracker.service.jwt_service.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;
    private final ModelMapper modelMapper;

    private final RoleRepository roleRepository;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }

        /*var user = new User()
                .setFullName(input.getFullName())
                .setEmail(input.getEmail())
                .setPassword(passwordEncoder.encode(input.getPassword()))
                .setRole(optionalRole.get());*/


        User signup = authenticationService.signup(registerUserDto);
        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(signup);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
//        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}