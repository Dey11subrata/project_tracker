package com.project.springboot.project_tracker.dto.user_dto;


import com.project.springboot.project_tracker.constants.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterUserDto {
    private String email;
    private String password;
    private String fullName;
    private RoleName roleName;

}
