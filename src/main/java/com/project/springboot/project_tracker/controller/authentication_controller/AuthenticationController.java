package com.project.springboot.project_tracker.controller.authentication_controller;

import com.project.springboot.project_tracker.constants.RoleName;
import com.project.springboot.project_tracker.dto.user_dto.LoginUserDto;
import com.project.springboot.project_tracker.dto.user_dto.RegisterUserDto;
import com.project.springboot.project_tracker.model.users.User;
import com.project.springboot.project_tracker.response.LoginResponse;
import com.project.springboot.project_tracker.service.authentication_service.AuthenticationService;
import com.project.springboot.project_tracker.service.jwt_service.JwtService;
import com.project.springboot.project_tracker.utility.response.SignUpResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;
    private final ModelMapper modelMapper;


    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService, ModelMapper modelMapper) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
        this.modelMapper = modelMapper;

    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> register(@RequestBody RegisterUserDto registerUserDto) {
        // check if role in given or not
        SignUpResponse signUpResponse = new SignUpResponse();
        // set default value
        signUpResponse.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
        signUpResponse.setMessage("OOPs!!...Something Went Wrong...");
        if(registerUserDto.getRoleName().toString().isEmpty()){
            // assign default role
            registerUserDto.setRoleName(RoleName.USER);
        }

        User signup = authenticationService.signup(registerUserDto);
        if(signup != null){
            signUpResponse.setStatus(HttpStatus.CREATED.value());
            signUpResponse.setMessage("Registration Successful...");
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("user-registered", "true")
                    .body(signUpResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .header("user-registerd", "false")
                .body(signUpResponse);
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