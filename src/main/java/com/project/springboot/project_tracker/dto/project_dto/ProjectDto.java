package com.project.springboot.project_tracker.dto.project_dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectDto {
    private String projectName;
    private String productOwner;
    private String projectManager;
    private String projectStatus;
    private String specialNotes;
    private LocalDate projectStartDate;
    private LocalDate projectEstimatedCompletionDate;
}
