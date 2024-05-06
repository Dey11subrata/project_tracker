package com.project.springboot.project_tracker.model.project.sprint;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Sprint {
    private int sprintId;
    private String sprintName;
    private int sprintDuration;
    private LocalDate sprintStartDate;
    private LocalDate sprintEndDate;
    private String sprintGoal;
}
