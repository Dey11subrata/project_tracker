package com.project.springboot.project_tracker.dto.user_dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {

    private String userFirstName;

    private String userLastName;

    private String userDeptCode;

    private String userRole;

    private String userEmail;

}
