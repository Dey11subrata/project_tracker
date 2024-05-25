package com.project.springboot.project_tracker.service.authentication_service;

import com.project.springboot.project_tracker.dto.user_dto.LoginUserDto;
import com.project.springboot.project_tracker.dto.user_dto.RegisterUserDto;
import com.project.springboot.project_tracker.dto.user_dto.UserDto;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.repository.user_repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    // include model mapper
    private ModelMapper modelMapper;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            ModelMapper modelMapper
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    public User signup(RegisterUserDto input) {

        User user = modelMapper.map(input, User.class);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        new User()
//                .setFullName(input.getFullName())
//                .setEmail(input.getEmail())
//                .setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
