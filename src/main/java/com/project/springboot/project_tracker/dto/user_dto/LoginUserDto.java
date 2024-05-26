package com.project.springboot.project_tracker.dto.user_dto;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;
}
