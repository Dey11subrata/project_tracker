package com.project.springboot.project_tracker.service.project_service.sprint_service;

import com.project.springboot.project_tracker.model.project.sprint.Sprint;

import java.util.List;

public interface SprintService {
    Sprint createSpring(Sprint sprint);

    List<Sprint> getListOfAllSprint();
}
