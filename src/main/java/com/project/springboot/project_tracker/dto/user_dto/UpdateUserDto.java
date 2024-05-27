package com.project.springboot.project_tracker.dto.user_dto;


import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class UpdateUserDto {

    private Integer id;

    private String fullName;

    private String email;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private LocalDate deletedAt;

    private boolean isDeleted;
}
