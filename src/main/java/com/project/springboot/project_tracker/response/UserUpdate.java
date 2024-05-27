package com.project.springboot.project_tracker.response;

import com.project.springboot.project_tracker.dto.user_dto.UpdateUserDto;
import lombok.Data;

@Data
public class UserUpdate {
    private String message;
    private UpdateUserDto updateUserDto;
}
