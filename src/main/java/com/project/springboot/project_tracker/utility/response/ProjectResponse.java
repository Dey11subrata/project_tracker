package com.project.springboot.project_tracker.utility.response;

import com.project.springboot.project_tracker.model.project.Project;
import lombok.Data;

@Data
public class ProjectResponse {
    private int status;
    private String message;
    private Project project;
}
