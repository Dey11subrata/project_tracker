package com.project.springboot.project_tracker.utility;

import com.project.springboot.project_tracker.dto.user_dto.UserWithUpdatedDetails;
import com.project.springboot.project_tracker.model.users.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class VerifyUserContext {
    public static boolean verifyUserContext(User user ){
        if (SecurityContextHolder.getContext().getAuthentication().getName().equals(user.getUsername())){
            return true;
        }
        return false;
    }
}
