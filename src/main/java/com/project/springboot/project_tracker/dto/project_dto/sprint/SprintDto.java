package com.project.springboot.project_tracker.dto.project_dto.sprint;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SprintDto {
    private String sprintName;
    private int sprintDuration;
    private LocalDate sprintStartDate;
    private LocalDate sprintEndDate;
    private String sprintGoal;
}
