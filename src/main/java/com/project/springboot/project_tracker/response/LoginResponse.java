package com.project.springboot.project_tracker.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;

}
