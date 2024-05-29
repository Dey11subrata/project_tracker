package com.project.springboot.project_tracker.dto.user_dto;

import com.project.springboot.project_tracker.constants.RoleEnum;
import com.project.springboot.project_tracker.model.users.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;
    private Role role;
}
