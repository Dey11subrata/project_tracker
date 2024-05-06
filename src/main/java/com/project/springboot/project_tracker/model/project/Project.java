package com.project.springboot.project_tracker.model.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;

    @NotBlank(message = "oroject name can not be left blank")
    private String projectName;

    @NotBlank(message = "project owner can not be left blank")
    private String productOwner;
    private String projectManager;
    private String projectStatus;
    private String specialNotes;
    private LocalDate projectStartDate;
    private LocalDate projectEstimatedCompletionDate;
//    private LocalDate projectActualCompletionDate;
}
