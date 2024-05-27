package com.project.springboot.project_tracker.dto.user_dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserWithUpdatedDetails {

    private Integer id;

    private String fullName;

    private LocalDate updatedAt;

    private LocalDate deletedAt;

    private boolean isDeleted;
}
