package com.project.springboot.project_tracker.service.project_service;

import com.project.springboot.project_tracker.model.project.Project;

import java.util.List;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> getListOfAllProject();
}
