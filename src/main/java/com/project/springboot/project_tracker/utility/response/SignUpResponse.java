package com.project.springboot.project_tracker.utility.response;

import com.project.springboot.project_tracker.model.users.User;
import lombok.Data;

@Data
public class SignUpResponse {
    private int status;
    private String message;

//    private User user; // for testing to check full response
}
